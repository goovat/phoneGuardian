package com.goovat.phoneguardian.evidence

class OfflineEventQueue {

    private val events = mutableListOf<SecurityEvent>()

    fun enqueue(event: SecurityEvent) {
        events.add(event)
    }

    fun events(): List<SecurityEvent> = events.toList()

    fun remove(event: SecurityEvent) {
        events.remove(event)
    }
}
