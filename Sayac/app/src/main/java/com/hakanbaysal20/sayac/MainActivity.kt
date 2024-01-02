package com.hakanbaysal20.sayac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.sayac.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ap = AppRef(this)

        val job = CoroutineScope(Dispatchers.Main).launch {
            var gelenSayac = ap.okuSayac()
            ap.kayitSayac(++gelenSayac)

          //  val value = ap.sayac()
          //  binding.textviewsayac.text = value.toString()
            binding.textviewsayac.text = "Açılış sayısı :  $gelenSayac"
        }
    }
}