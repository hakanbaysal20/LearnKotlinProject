package com.hakanbaysal20.sayitahminet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.hakanbaysal20.sayitahminet.databinding.ActivityTahminBinding
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTahminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTahminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sayi = Random.nextInt(1,101)
        Log.e("sayı","$sayi")
        var kalanHak = 5
        binding.button.setOnClickListener {
            val gelen = binding.editText.text.toString()
            if (sayi == gelen.toInt()){
                val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuç",true)
                startActivity(intent)
            }else{
                kalanHak -= 1
                if (kalanHak == 0){
                    val intent = Intent(this@TahminActivity,SonucActivity::class.java)
                    intent.putExtra("sonuç",false)
                    startActivity(intent)
                }else{
                    binding.kalanHak.text = "Kalan Hak : $kalanHak"
                    if (sayi > gelen.toInt()){
                        binding.helpText.text = "ARTTIR"
                    }else if (sayi < gelen.toInt()){
                        binding.helpText.text = "AZALT"
                    }
                    binding.helpText.visibility = View.VISIBLE
                }

            }
        }
    }
}