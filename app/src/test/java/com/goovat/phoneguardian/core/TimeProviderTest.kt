package com.goovat.phoneguardian.core

import org.junit.Assert.assertEquals
import org.junit.Test

class TimeProviderTest {

    @Test
    fun provider_returns_current_time() {
        val expected = 123456789L

        val provider = object : TimeProvider {
            override fun currentTimeMillis(): Long = expected
        }

        assertEquals(expected, provider.currentTimeMillis())
    }
}
