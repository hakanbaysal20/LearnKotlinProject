package com.hakanbaysal20.sayitahminet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.sayitahminet.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySonucBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySonucBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val alinanDeger = intent.getBooleanExtra("sonuç",false)

        if (alinanDeger == false){
           binding.textView.text = "KAYBETTİNİZ"
            binding.imageView.setImageResource(R.drawable.unhappy)
        }else{
            binding.imageView.setImageResource(R.drawable.happy)
            binding.textView.text = "KAZANDINIZ"

        }
        binding.button2.setOnClickListener {
           val intent = Intent(this@SonucActivity,TahminActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}