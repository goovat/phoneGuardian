package com.goovat.phoneguardian.evidence

import org.junit.Assert.assertEquals
import org.junit.Test

class SecurityEventTest {

    @Test
    fun stores_event_data() {
        val event = SecurityEvent(
            id = "event-1",
            type = SecurityEventType.SIM_CHANGED,
            timestampMillis = 1_000L,
            details = "SIM state changed"
        )

        assertEquals("event-1", event.id)
        assertEquals(SecurityEventType.SIM_CHANGED, event.type)
        assertEquals(1_000L, event.timestampMillis)
        assertEquals("SIM state changed", event.details)
    }

    @Test
    fun details_are_optional() {
        val event = SecurityEvent(
            id = "event-2",
            type = SecurityEventType.DEVICE_REBOOTED,
            timestampMillis = 2_000L
        )

        assertEquals(null, event.details)
    }
}
