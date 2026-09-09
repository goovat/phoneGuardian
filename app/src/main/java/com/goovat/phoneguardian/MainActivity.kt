package com.goovat.phoneguardian

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val phoneStatePermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            // SIM protection checks permission when it reads subscription state.
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestPhoneStatePermissionIfNeeded()
    }

    private fun requestPhoneStatePermissionIfNeeded() {
        if (
            !packageManager.hasSystemFeature(
                PackageManager.FEATURE_TELEPHONY_SUBSCRIPTION
            )
        ) {
            return
        }

        if (
            checkSelfPermission(Manifest.permission.READ_PHONE_STATE) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            phoneStatePermissionLauncher.launch(
                Manifest.permission.READ_PHONE_STATE
            )
        }
    }
}
