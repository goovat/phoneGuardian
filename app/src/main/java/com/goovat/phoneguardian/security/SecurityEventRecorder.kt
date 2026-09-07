package com.goovat.phoneguardian.security

import com.goovat.phoneguardian.evidence.SecurityEvent

class SecurityEventRecorder(
    private val store: SecurityEventStore
) {
    fun record(event: SecurityEvent) {
        store.record(event)
    }
}
