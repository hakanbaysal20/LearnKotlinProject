package com.hakanbaysal20.ilkproje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hakanbaysal20.ilkproje.databinding.ActivityYeniSayfaOlusturmaBinding

class YeniSayfaOlusturma : AppCompatActivity() {
    private lateinit var tasarim:ActivityYeniSayfaOlusturmaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityYeniSayfaOlusturmaBinding.inflate(layoutInflater)
        setContentView(tasarim.root)
        val gelenMesaj = intent.getStringExtra("mesaj")
        val gelenKisi = intent.getSerializableExtra("object") as Kisiler
    //    val gelenYas = intent.getIntExtra("yas",0)
        //val gelenIsim = intent.getStringExtra("isim")
      //  val gelenBoy = intent.getDoubleExtra("boy",0.0)
        val intent = Intent(this@YeniSayfaOlusturma,ActivityC::class.java)
        tasarim.gelenmesaj.text = ("$gelenMesaj ${gelenKisi.isim}, sen ${gelenKisi.yas} yaşında ${gelenKisi.boy} boyunda bir insansın")
        tasarim.benim.setOnClickListener {
            startActivity(intent)
        }
        Log.e("mesaj",gelenMesaj.toString())
   //     Log.e("yaş",gelenYas.toString())
   //     Log.e("isim",gelenIsim.toString())
     //   Log.e("boy",gelenBoy.toString())
    }
    override fun onBackPressed() {
        val yeniIntent = Intent(Intent.ACTION_MAIN)
        yeniIntent.addCategory(Intent.CATEGORY_HOME)
        yeniIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        startActivity(yeniIntent)
    }
}