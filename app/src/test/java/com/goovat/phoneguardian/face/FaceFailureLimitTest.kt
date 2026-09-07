package com.goovat.phoneguardian.face

import org.junit.Assert.assertEquals
import org.junit.Test

class FaceFailureLimitTest {

    @Test
    fun stores_failure_limit() {
        val limit = FaceFailureLimit(3)

        assertEquals(3, limit.value)
    }
}
