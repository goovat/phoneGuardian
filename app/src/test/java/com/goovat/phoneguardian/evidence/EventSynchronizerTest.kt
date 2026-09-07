package com.goovat.phoneguardian.evidence

import org.junit.Assert.assertEquals
import org.junit.Test

class EventSynchronizerTest {

    @Test
    fun synchronizes_events_in_queue_order() {
        val queue = OfflineEventQueue()
        val first = securityEvent(
            id = "event-1",
            type = SecurityEventType.LOCATION_UPDATED,
            timestampMillis = 1_000L
        )
        val second = securityEvent(
            id = "event-2",
            type = SecurityEventType.SIM_CHANGED,
            timestampMillis = 2_000L
        )
        val transport = RecordingEventTransport()

        queue.enqueue(first)
        queue.enqueue(second)

        EventSynchronizer(queue, transport).synchronize()

        assertEquals(listOf(first, second), transport.sentEvents)
    }

    @Test
    fun removes_successfully_synchronized_events() {
        val queue = OfflineEventQueue()
        val first = securityEvent(
            id = "event-1",
            type = SecurityEventType.LOCATION_UPDATED,
            timestampMillis = 1_000L
        )
        val second = securityEvent(
            id = "event-2",
            type = SecurityEventType.SIM_CHANGED,
            timestampMillis = 2_000L
        )

        queue.enqueue(first)
        queue.enqueue(second)

        EventSynchronizer(
            queue,
            RecordingEventTransport()
        ).synchronize()

        assertEquals(emptyList<SecurityEvent>(), queue.events())
    }

    @Test
    fun keeps_failed_event_and_later_events_in_queue() {
        val queue = OfflineEventQueue()
        val first = securityEvent(
            id = "event-1",
            type = SecurityEventType.LOCATION_UPDATED,
            timestampMillis = 1_000L
        )
        val second = securityEvent(
            id = "event-2",
            type = SecurityEventType.SIM_CHANGED,
            timestampMillis = 2_000L
        )
        val transport = RecordingEventTransport(
            failureEventId = first.id
        )

        queue.enqueue(first)
        queue.enqueue(second)

        val result = EventSynchronizer(queue, transport).synchronize()

        assertEquals(true, result.isFailure)
        assertEquals(listOf(first, second), queue.events())
    }

    @Test
    fun stops_after_first_failed_event() {
        val queue = OfflineEventQueue()
        val first = securityEvent(
            id = "event-1",
            type = SecurityEventType.LOCATION_UPDATED,
            timestampMillis = 1_000L
        )
        val second = securityEvent(
            id = "event-2",
            type = SecurityEventType.SIM_CHANGED,
            timestampMillis = 2_000L
        )
        val third = securityEvent(
            id = "event-3",
            type = SecurityEventType.DEVICE_REBOOTED,
            timestampMillis = 3_000L
        )
        val transport = RecordingEventTransport(
            failureEventId = second.id
        )

        queue.enqueue(first)
        queue.enqueue(second)
        queue.enqueue(third)

        EventSynchronizer(queue, transport).synchronize()

        assertEquals(listOf(first, second), transport.sentEvents)
        assertEquals(listOf(second, third), queue.events())
    }

    private fun securityEvent(
        id: String,
        type: SecurityEventType,
        timestampMillis: Long
    ): SecurityEvent {
        return SecurityEvent(
            id = id,
            type = type,
            timestampMillis = timestampMillis
        )
    }

    private class RecordingEventTransport(
        private val failureEventId: String? = null
    ) : EventTransport {

        val sentEvents = mutableListOf<SecurityEvent>()

        override fun send(event: SecurityEvent): Result<Unit> {
            sentEvents.add(event)

            return if (event.id == failureEventId) {
                Result.failure(IllegalStateException("Transport failure"))
            } else {
                Result.success(Unit)
            }
        }
    }
}
