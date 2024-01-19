package com.hakanbaysal20.chargelevelcontrol

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var chargeLevel:DetectChargeLevel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chargeLevel = DetectChargeLevel()
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter()
        filter.addAction("android.intent.action.BATTERY_LOW")
        registerReceiver(chargeLevel,filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(chargeLevel)
    }
}