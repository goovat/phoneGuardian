package com.goovat.phoneguardian.sim

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.telephony.SubscriptionManager

data class SimStateDetection(
    val subscriptionId: String
) {

    companion object {

        fun current(context: Context): SimStateDetection? {
            if (
                context.checkSelfPermission(
                    Manifest.permission.READ_PHONE_STATE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return null
            }

            val subscriptionManager =
                context.getSystemService(SubscriptionManager::class.java)
                    ?: return null

            val subscriptions =
                subscriptionManager.activeSubscriptionInfoList
                    ?: return null

            val subscriptionIds = subscriptions
                .map { it.subscriptionId }
                .sorted()
                .joinToString(",")

            return SimStateDetection(subscriptionIds)
        }
    }
}
