package com.goovat.phoneguardian.security

import com.goovat.phoneguardian.evidence.SecurityEvent

interface SecurityEventStore {
    fun record(event: SecurityEvent)
}
