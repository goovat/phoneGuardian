package com.goovat.phoneguardian.core

import android.util.Log

object AppLogger {

    private const val TAG = "PhoneGuardian"

    fun debug(message: String) {
        Log.d(TAG, message)
    }

    fun info(message: String) {
        Log.i(TAG, message)
    }

    fun warning(message: String) {
        Log.w(TAG, message)
    }

    fun error(message: String, cause: Throwable? = null) {
        Log.e(TAG, message, cause)
    }
}
