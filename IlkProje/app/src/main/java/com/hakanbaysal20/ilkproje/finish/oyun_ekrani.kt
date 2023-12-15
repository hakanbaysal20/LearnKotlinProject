package com.hakanbaysal20.ilkproje.finish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.ilkproje.R
import com.hakanbaysal20.ilkproje.databinding.ActivityOyunEkraniBinding

class oyun_ekrani : AppCompatActivity() {
    private lateinit var binding:ActivityOyunEkraniBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOyunEkraniBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bitirbuton.setOnClickListener {
            val intent = Intent(this@oyun_ekrani,SonucEkrani::class.java)
            finish()
            //finish(): Mevcut Activity'yi sonlandırır.
            //Intent.FLAG_ACTIVITY_CLEAR_TOP: Yeni bir Activity başlatılırken, hedef Activity'nin önceki tüm örneklerini temizleyerek en üste getirir.
            startActivity(intent)
        }
    }
}