package com.goovat.phoneguardian.evidence

import com.goovat.phoneguardian.history.SecurityHistory

class EvidenceTimeline(
    private val history: SecurityHistory
) {

    fun events(): List<SecurityEvent> = history.events().toList()
}
