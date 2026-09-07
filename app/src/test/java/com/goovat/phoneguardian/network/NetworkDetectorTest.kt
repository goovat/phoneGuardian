package com.goovat.phoneguardian.network

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class NetworkDetectorTest {

    @Test
    fun detects_wifi_to_mobile_change() {
        val detector = NetworkDetector()

        assertTrue(
            detector.detect(
                NetworkState(NetworkType.WIFI),
                NetworkState(NetworkType.MOBILE)
            )
        )
    }

    @Test
    fun detects_mobile_to_wifi_change() {
        val detector = NetworkDetector()

        assertTrue(
            detector.detect(
                NetworkState(NetworkType.MOBILE),
                NetworkState(NetworkType.WIFI)
            )
        )
    }

    @Test
    fun detects_none_to_wifi_change() {
        val detector = NetworkDetector()

        assertTrue(
            detector.detect(
                NetworkState(NetworkType.NONE),
                NetworkState(NetworkType.WIFI)
            )
        )
    }

    @Test
    fun detects_wifi_to_none_change() {
        val detector = NetworkDetector()

        assertTrue(
            detector.detect(
                NetworkState(NetworkType.WIFI),
                NetworkState(NetworkType.NONE)
            )
        )
    }

    @Test
    fun reports_no_change_when_network_is_unchanged() {
        val detector = NetworkDetector()

        assertFalse(
            detector.detect(
                NetworkState(NetworkType.WIFI),
                NetworkState(NetworkType.WIFI)
            )
        )
    }

    @Test
    fun reports_no_change_when_both_are_disconnected() {
        val detector = NetworkDetector()

        assertFalse(
            detector.detect(
                NetworkState(NetworkType.NONE),
                NetworkState(NetworkType.NONE)
            )
        )
    }
}
