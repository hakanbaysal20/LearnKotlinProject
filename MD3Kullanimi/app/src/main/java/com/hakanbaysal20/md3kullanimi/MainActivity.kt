package com.hakanbaysal20.md3kullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.hakanbaysal20.md3kullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            Toast.makeText(applicationContext,"Merhaba",Toast.LENGTH_SHORT).show()
        }
        binding.button.setOnClickListener {
            val ad = binding.edittextAd.text.toString().trim() // whitespaceler silinir
            val tel = binding.edittextTel.text.toString().trim()
            if (tel.length < 6){
                Toast.makeText(applicationContext,"Tel en az 6 hane olmalıdır",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
           if (TextUtils.isEmpty(tel)){
               Toast.makeText(applicationContext,"Telefonu girmediniz",Toast.LENGTH_SHORT).show()
               return@setOnClickListener
           }else if (TextUtils.isEmpty(ad)){
               Toast.makeText(applicationContext,"Adınızı girmediniz",Toast.LENGTH_SHORT).show()
               return@setOnClickListener
           }
            Toast.makeText(applicationContext,"$ad : $tel",Toast.LENGTH_SHORT).show()
        }
        binding.toolbar.title = "Menu"
        binding.toolbar.subtitle = "Food"
        binding.toolbar.setLogo(R.drawable.ic_menu)
        binding.toolbar.setTitleTextColor(resources.getColor(R.color.blue))
        setSupportActionBar(binding.toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.popup_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuInfo ->{
                Toast.makeText(applicationContext,"Bilgi basıldı",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menuEkle ->{
                Toast.makeText(applicationContext,"Ekle basıldı",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menuCikis ->{
                Toast.makeText(applicationContext,"Çıkıldı",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.menuAyar ->{
                Toast.makeText(applicationContext,"Ayar",Toast.LENGTH_SHORT).show()
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
}