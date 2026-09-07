package com.goovat.phoneguardian.history

import com.goovat.phoneguardian.evidence.SecurityEvent
import com.goovat.phoneguardian.evidence.SecurityEventType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotSame
import org.junit.Test

class SecurityHistoryTest {

    @Test
    fun records_events_in_insertion_order() {
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

        assertEquals(listOf(first, second), history.events())
    }

    @Test
    fun events_returns_a_snapshot() {
        val history = SecurityHistory()
        val event = SecurityEvent(
            id = "event-1",
            type = SecurityEventType.DEVICE_REBOOTED,
            timestampMillis = 1_000L
        )

        history.record(event)

        val firstSnapshot = history.events()
        val secondSnapshot = history.events()

        assertEquals(listOf(event), firstSnapshot)
        assertNotSame(firstSnapshot, secondSnapshot)
    }
}
