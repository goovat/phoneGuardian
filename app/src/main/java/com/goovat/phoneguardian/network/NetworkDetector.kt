package com.goovat.phoneguardian.network

class NetworkDetector {

    fun detect(
        previous: NetworkState,
        current: NetworkState
    ): Boolean {
        return previous != current
    }
}
