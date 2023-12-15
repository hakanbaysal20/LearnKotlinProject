package com.hakanbaysal20.ilkproje.finish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.ilkproje.R
import com.hakanbaysal20.ilkproje.databinding.ActivityGirisBinding
import com.hakanbaysal20.ilkproje.databinding.ActivityOyunEkraniBinding

class giris : AppCompatActivity() {
    private lateinit var binding:ActivityGirisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityGirisBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.oyna.setOnClickListener {
            val intent = Intent(this@giris,oyun_ekrani::class.java)

            startActivity(intent)
        }
    }
}