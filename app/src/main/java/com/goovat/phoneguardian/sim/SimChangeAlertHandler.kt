package com.goovat.phoneguardian.sim

import com.goovat.phoneguardian.core.TimeProvider
import com.goovat.phoneguardian.evidence.SecurityEvent
import com.goovat.phoneguardian.evidence.SecurityEventType
import com.goovat.phoneguardian.security.SecurityEventRecorder

class SimChangeAlertHandler(
    private val recorder: SecurityEventRecorder,
    private val timeProvider: TimeProvider
) {

    fun handle(
        alert: SimChangeAlert,
        eventId: String
    ) {
        val event = SecurityEvent(
            id = eventId,
            type = SecurityEventType.SIM_CHANGED,
            timestampMillis = timeProvider.currentTimeMillis(),
            details = "SIM subscription changed from " +
                "${alert.event.previousSubscriptionId} to " +
                alert.event.currentSubscriptionId
        )

        recorder.record(event)
    }
}
