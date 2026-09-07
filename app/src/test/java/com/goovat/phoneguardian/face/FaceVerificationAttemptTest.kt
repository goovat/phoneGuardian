package com.goovat.phoneguardian.face

import org.junit.Assert.assertEquals
import org.junit.Test

class FaceVerificationAttemptTest {

    @Test
    fun stores_verification_attempt() {
        val attempt = FaceVerificationAttempt(
            result = FaceVerificationResult.VERIFIED,
            timestampMillis = 123456789L
        )

        assertEquals(FaceVerificationResult.VERIFIED, attempt.result)
        assertEquals(123456789L, attempt.timestampMillis)
    }
}
