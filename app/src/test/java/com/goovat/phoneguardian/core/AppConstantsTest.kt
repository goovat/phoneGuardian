package com.goovat.phoneguardian.core

import org.junit.Assert.assertEquals
import org.junit.Test

class AppConstantsTest {

    @Test
    fun app_name_is_phone_guardian() {
        assertEquals("PhoneGuardian", AppConstants.APP_NAME)
    }

    @Test
    fun default_alarm_duration_is_30_seconds() {
        assertEquals(30_000L, AppConstants.DEFAULT_ALARM_DURATION_MILLIS)
    }

    @Test
    fun default_authentication_timeout_is_30_seconds() {
        assertEquals(
            30_000L,
            AppConstants.DEFAULT_AUTHENTICATION_TIMEOUT_MILLIS
        )
    }

    @Test
    fun default_pickup_delay_is_2_seconds() {
        assertEquals(2_000L, AppConstants.DEFAULT_PICKUP_DELAY_MILLIS)
    }
}
