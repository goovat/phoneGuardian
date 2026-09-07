package com.goovat.phoneguardian.usb

import org.junit.Assert.assertEquals
import org.junit.Test

class UsbDetectorTest {

    @Test
    fun detects_usb_connection() {
        val detector = UsbDetector()

        val state = detector.detect(
            wasConnected = false,
            isConnected = true
        )

        assertEquals(UsbState.CONNECTED, state)
    }

    @Test
    fun detects_usb_disconnection() {
        val detector = UsbDetector()

        val state = detector.detect(
            wasConnected = true,
            isConnected = false
        )

        assertEquals(UsbState.DISCONNECTED, state)
    }

    @Test
    fun reports_unchanged_when_still_connected() {
        val detector = UsbDetector()

        val state = detector.detect(
            wasConnected = true,
            isConnected = true
        )

        assertEquals(UsbState.UNCHANGED, state)
    }

    @Test
    fun reports_unchanged_when_still_disconnected() {
        val detector = UsbDetector()

        val state = detector.detect(
            wasConnected = false,
            isConnected = false
        )

        assertEquals(UsbState.UNCHANGED, state)
    }
}
