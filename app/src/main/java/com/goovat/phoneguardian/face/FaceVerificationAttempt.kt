package com.goovat.phoneguardian.face

data class FaceVerificationAttempt(
    val result: FaceVerificationResult,
    val timestampMillis: Long
)
