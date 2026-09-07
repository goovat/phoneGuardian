package com.goovat.phoneguardian.evidence

data class SecurityEvent(
    val id: String,
    val type: SecurityEventType,
    val timestampMillis: Long,
    val details: String? = null
)
