package com.hakanbaysal20.sharedpreferencesusage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.sharedpreferencesusage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sp = getSharedPreferences("KişiselBilgiler", Context.MODE_PRIVATE)
        val editor = sp.edit()

        // sayac
        var sayac = sp.getInt("sayac",0)
        editor.putInt("sayac",++sayac)
        editor.putString("ad","Ahmet")
        editor.putInt("yas",18)
        editor.putFloat("boy",1.78f)
        editor.putBoolean("bekarMi",true)
        val arkadasListesi = HashSet<String>()
        arkadasListesi.add("Zeynep")
        arkadasListesi.add("Ece")
        arkadasListesi.add("Eda")
        editor.putStringSet("arkadasListesi",arkadasListesi)
        editor.remove("ad") // çalıştığında ad keyindeki veri silinecek

        binding.textSayac.text = "Açılış Sayısı : $sayac"  //sayaç
        editor.commit()



        binding.buttonGec.setOnClickListener {
            val intent = Intent(this@MainActivity,ActivityB::class.java)
            startActivity(intent)
        }
    }
}