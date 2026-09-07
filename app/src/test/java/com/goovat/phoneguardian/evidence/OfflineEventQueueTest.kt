package com.goovat.phoneguardian.evidence

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotSame
import org.junit.Test

class OfflineEventQueueTest {

    @Test
    fun enqueues_events_in_order() {
        val queue = OfflineEventQueue()
        val first = SecurityEvent(
            id = "event-1",
            type = SecurityEventType.LOCATION_UPDATED,
            timestampMillis = 1_000L
        )
        val second = SecurityEvent(
            id = "event-2",
            type = SecurityEventType.SIM_CHANGED,
            timestampMillis = 2_000L
        )

        queue.enqueue(first)
        queue.enqueue(second)

        assertEquals(listOf(first, second), queue.events())
    }

    @Test
    fun events_returns_a_snapshot() {
        val queue = OfflineEventQueue()
        val event = SecurityEvent(
            id = "event-1",
            type = SecurityEventType.NETWORK_CHANGED,
            timestampMillis = 1_000L
        )

        queue.enqueue(event)

        val firstSnapshot = queue.events()
        val secondSnapshot = queue.events()

        assertEquals(listOf(event), firstSnapshot)
        assertNotSame(firstSnapshot, secondSnapshot)
    }

    @Test
    fun removes_an_event() {
        val queue = OfflineEventQueue()
        val first = SecurityEvent(
            id = "event-1",
            type = SecurityEventType.LOCATION_UPDATED,
            timestampMillis = 1_000L
        )
        val second = SecurityEvent(
            id = "event-2",
            type = SecurityEventType.SIM_CHANGED,
            timestampMillis = 2_000L
        )

        queue.enqueue(first)
        queue.enqueue(second)

        queue.remove(first)

        assertEquals(listOf(second), queue.events())
    }
}
