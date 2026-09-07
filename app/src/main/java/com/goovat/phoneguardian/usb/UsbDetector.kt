package com.goovat.phoneguardian.usb

class UsbDetector {

    fun detect(
        wasConnected: Boolean,
        isConnected: Boolean
    ): UsbState {
        return when {
            !wasConnected && isConnected -> UsbState.CONNECTED
            wasConnected && !isConnected -> UsbState.DISCONNECTED
            else -> UsbState.UNCHANGED
        }
    }
}
