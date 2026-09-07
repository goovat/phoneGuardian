package com.goovat.phoneguardian.core

interface TimeProvider {
    fun currentTimeMillis(): Long
}
