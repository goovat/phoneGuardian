package com.goovat.phoneguardian.face

import org.junit.Assert.assertEquals
import org.junit.Test

class FaceVerificationTimeoutTest {

    @Test
    fun stores_timeout_duration() {
        val timeout = FaceVerificationTimeout(30_000L)

        assertEquals(30_000L, timeout.durationMillis)
    }
}
