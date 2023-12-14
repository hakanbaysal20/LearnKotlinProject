package com.hakanbaysal20.ilkproje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginekrantasarimi)

        Log.e("ÇIKTI","MESAJ")
        Log.e("Başlık","İçerik")
    }

}