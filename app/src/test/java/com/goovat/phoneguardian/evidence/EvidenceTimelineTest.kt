package com.goovat.phoneguardian.evidence

import com.goovat.phoneguardian.history.SecurityHistory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotSame
import org.junit.Test

class EvidenceTimelineTest {

    @Test
    fun exposes_history_events_in_order() {
        val history = SecurityHistory()
        val first = SecurityEvent(
            id = "event-1",
            type = SecurityEventType.DEVICE_PICKUP,
            timestampMillis = 1_000L
        )
        val second = SecurityEvent(
            id = "event-2",
            type = SecurityEventType.SIM_CHANGED,
            timestampMillis = 2_000L
        )

        history.record(first)
        history.record(second)

        val timeline = EvidenceTimeline(history)

        assertEquals(listOf(first, second), timeline.events())
    }

    @Test
    fun events_returns_a_snapshot() {
        val history = SecurityHistory()
        val event = SecurityEvent(
            id = "event-1",
            type = SecurityEventType.LOCATION_UPDATED,
            timestampMillis = 1_000L
        )

        history.record(event)

        val timeline = EvidenceTimeline(history)
        val firstSnapshot = timeline.events()
        val secondSnapshot = timeline.events()

        assertEquals(listOf(event), firstSnapshot)
        assertNotSame(firstSnapshot, secondSnapshot)
    }
}
