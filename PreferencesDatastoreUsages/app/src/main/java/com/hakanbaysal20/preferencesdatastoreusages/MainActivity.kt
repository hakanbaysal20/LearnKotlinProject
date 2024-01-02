package com.hakanbaysal20.preferencesdatastoreusages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hakanbaysal20.preferencesdatastoreusages.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ap = AppPref(this)
        val kisi = Kisi("Hakan",22,1.9f,true)
        val arkadasList = HashSet<String>()
        arkadasList.add("Furkan")
        arkadasList.add("Enes")
        arkadasList.add("Kamil")

       /* val job = CoroutineScope(Dispatchers.Main).launch {
           ap.silAd()
            val gelenAd = ap.okuAd()
            Log.e("Gelen ad",gelenAd)
        }*/
        val job = CoroutineScope(Dispatchers.Main).launch {
            ap.kayitKisi(kisi)
            val gelenKisi = ap.okuKisi()
            Log.e("AD",gelenKisi.ad)
            Log.e("YAŞ",gelenKisi.yas.toString())
            Log.e("Boy",gelenKisi.boy.toString())
            Log.e("Bekar mı",gelenKisi.bekarMi.toString())
            ap.kayitArkadaslarListesi(arkadasList) // hashset liste kaydı
            ap.silArkadasListesi() // sildiği için okunmaz

            val gelenListe = ap.okuArkadasListesi()
            if (gelenListe != null){
                for (a in gelenListe){
                    Log.e("Gelen",a)
                }
            }

        }
    }
}