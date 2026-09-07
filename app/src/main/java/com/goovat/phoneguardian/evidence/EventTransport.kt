package com.goovat.phoneguardian.evidence

interface EventTransport {
    fun send(event: SecurityEvent): Result<Unit>
}
