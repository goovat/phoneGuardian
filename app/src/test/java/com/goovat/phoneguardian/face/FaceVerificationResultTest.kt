package com.goovat.phoneguardian.face

import org.junit.Assert.assertEquals
import org.junit.Test

class FaceVerificationResultTest {

    @Test
    fun contains_expected_results() {
        assertEquals(
            listOf(
                FaceVerificationResult.VERIFIED,
                FaceVerificationResult.NOT_VERIFIED,
                FaceVerificationResult.UNAVAILABLE
            ),
            FaceVerificationResult.entries
        )
    }
}
