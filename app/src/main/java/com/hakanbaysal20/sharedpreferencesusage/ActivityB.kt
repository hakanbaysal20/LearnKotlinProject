package com.hakanbaysal20.sharedpreferencesusage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hakanbaysal20.sharedpreferencesusage.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {
    private lateinit var binding:ActivityBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sp = getSharedPreferences("KişiselBilgiler", Context.MODE_PRIVATE)

        val ad = sp.getString("ad","isim yok")
        val yas = sp.getInt("yas",0)
        val boy = sp.getFloat("boy",0.0f)
        val bekarMi = sp.getBoolean("bekarMi",false)
        val list = sp.getStringSet("arkadasListesi",null)
        Log.e("Ad",ad.toString())
        Log.e("Yas",yas.toString())
        Log.e("Boy",boy.toString())
        Log.e("BekarMi",bekarMi.toString())
        if (list != null){
            for (obj in list){
                Log.e("isim",obj)
            }
        }


    }
}