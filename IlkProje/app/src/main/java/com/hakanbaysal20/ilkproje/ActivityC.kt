package com.hakanbaysal20.ilkproje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
    }

    override fun onBackPressed() { //// bu metodla geri tusuna basıldıgında hangi sayfaya gideceğimize karar veriyoruz(b'yi görmeden a ya gidiyor.)
        val yeniIntent = Intent(this@ActivityC,MainActivity::class.java)
        startActivity(yeniIntent)
    }
}