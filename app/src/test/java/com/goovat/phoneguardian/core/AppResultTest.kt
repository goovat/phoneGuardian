package com.goovat.phoneguardian.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AppResultTest {

    @Test
    fun success_contains_data() {
        val result = AppResult.Success("verified")

        assertEquals("verified", result.data)
    }

    @Test
    fun failure_contains_message() {
        val result = AppResult.Failure("Authentication failed")

        assertEquals("Authentication failed", result.message)
        assertTrue(result.cause == null)
    }
}
