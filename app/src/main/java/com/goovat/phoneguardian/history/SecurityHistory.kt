package com.goovat.phoneguardian.history

import com.goovat.phoneguardian.evidence.SecurityEvent
import com.goovat.phoneguardian.security.SecurityEventStore

class SecurityHistory : SecurityEventStore {

    private val events = mutableListOf<SecurityEvent>()

    override fun record(event: SecurityEvent) {
        events.add(event)
    }

    fun events(): List<SecurityEvent> = events.toList()
}
