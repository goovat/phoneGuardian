package com.goovat.phoneguardian.core

import org.junit.Test

class AppLoggerTest {

    @Test
    fun logger_methods_can_be_called() {
        AppLogger.debug("debug")
        AppLogger.info("info")
        AppLogger.warning("warning")
        AppLogger.error("error")
    }
}
