package com.goovat.phoneguardian.face

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class FaceVerificationEnabledTest {

    @Test
    fun stores_enabled_state() {
        assertTrue(FaceVerificationEnabled(true).value)
        assertFalse(FaceVerificationEnabled(false).value)
    }
}
