package com.hakanbaysal20.ilkproje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.hakanbaysal20.ilkproje.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)
        val kisi = Kisiler(23,"Hakan",1.90)
        var a = 0

        tasarim.buttonYap.setOnClickListener{
            a += 1
            Snackbar.make(it,"Merhaba",Snackbar.LENGTH_SHORT).show()
            tasarim.textview.text = "Counter $a"
            Log.e("oncreate","Çalıştı")
        }
        tasarim.gec.setOnClickListener {
            val intent = Intent(this@MainActivity,YeniSayfaOlusturma::class.java)
            intent.putExtra("mesaj","Merhaba")
          // intent.putExtra("yas",23)
          //  intent.putExtra("isim","Hakan")
          //  intent.putExtra("boy",1.98)
            intent.putExtra("object",kisi)
            startActivity(intent)
        }


        Log.e("ÇIKTI","MESAJ")
        Log.e("Başlık","İçerik")
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResume","Çalıştı")
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart","Çalıştı")
    }
    override fun onStop() {
        super.onStop()
        Log.e("onStop","Çalıştı")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("onRestart","Çalıştı")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy","Çalıştı")
    }

    override fun onPause() {
        super.onPause()
        Log.e("onPause","Çalıştı")
    }
    override fun onBackPressed() { /// c den a ya geri dondugumuzde a'da geriye basıldığında c'ye dönmemesi adına bunu yazdık
        val yeniIntent = Intent(Intent.ACTION_MAIN)
        yeniIntent.addCategory(Intent.CATEGORY_HOME)
        yeniIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        startActivity(yeniIntent)
    }

}