package com.goovat.phoneguardian.security

import com.goovat.phoneguardian.evidence.SecurityEvent
import com.goovat.phoneguardian.evidence.SecurityEventType
import org.junit.Assert.assertEquals
import org.junit.Test

class SecurityEventRecorderTest {

    @Test
    fun records_event_in_store() {
        val store = RecordingSecurityEventStore()
        val recorder = SecurityEventRecorder(store)
        val event = SecurityEvent(
            id = "event-1",
            type = SecurityEventType.SIM_CHANGED,
            timestampMillis = 1_000L,
            details = "SIM state changed"
        )

        recorder.record(event)

        assertEquals(event, store.recordedEvent)
    }

    private class RecordingSecurityEventStore : SecurityEventStore {

        var recordedEvent: SecurityEvent? = null

        override fun record(event: SecurityEvent) {
            recordedEvent = event
        }
    }
}
