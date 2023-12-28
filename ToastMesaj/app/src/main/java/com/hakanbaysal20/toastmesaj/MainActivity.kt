package com.hakanbaysal20.toastmesaj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.hakanbaysal20.toastmesaj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonNormal.setOnClickListener {
            Toast.makeText(this,"Merhaba",Toast.LENGTH_SHORT).show()
        }
        binding.buttonOzel.setOnClickListener {
            val tasarim = layoutInflater.inflate(R.layout.toast_tasarim,null)
            val textViewMesaj = tasarim.findViewById(R.id.textViewMesaj) as TextView
            textViewMesaj.text = "Merhaba Özel Mesaj"
            val toastOzel = Toast(applicationContext)
            toastOzel.view = tasarim
            toastOzel.setGravity(Gravity.BOTTOM or Gravity.CENTER_VERTICAL,0,0)
            toastOzel.duration = Toast.LENGTH_LONG
            toastOzel.show()

        }
        binding.buttonMenuAc.setOnClickListener {
            val popup = androidx.appcompat.widget.PopupMenu(this,binding.buttonMenuAc)
            popup.menuInflater.inflate(R.menu.popup_menu,popup.menu)
            popup.setOnMenuItemClickListener {item ->
                when(item.itemId){
                    R.id.action_sil ->{
                        Toast.makeText(applicationContext,"Sil seçildi",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_duzenle ->{
                        Toast.makeText(applicationContext,"Düzenle seçildi",Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
            popup.show()
        }
        binding.buttonAlertNormal.setOnClickListener {
            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setMessage("Mesaj")
            alert.setTitle("Başlık")
            alert.setIcon(R.drawable.umbrella)
            alert.setPositiveButton("Tamam"){ dialogInterface, i ->
                Toast.makeText(this@MainActivity,"Tamam tıklanıldı",Toast.LENGTH_SHORT).show()
            }
            alert.setNegativeButton("İptal"){ dialogInterface, i ->
                Toast.makeText(this@MainActivity,"İptal tıklanıldı",Toast.LENGTH_SHORT).show()
            }
            alert.create().show()
        }
        binding.buttonAlertOzel.setOnClickListener {
            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setMessage("Mesaj")
            alert.setTitle("Başlık")
            val tasarim = layoutInflater.inflate(R.layout.alert_tasarim,null)
            val editTextAlert = tasarim.findViewById(R.id.editTextAlert) as EditText
            alert.setView(tasarim)

            alert.setIcon(R.drawable.umbrella)
            alert.setPositiveButton("Kaydet"){ dialogInterface, i ->
                val alinanVeri = editTextAlert.text.toString()
                Toast.makeText(this@MainActivity,"${alinanVeri} kaydedildi",Toast.LENGTH_SHORT).show()
            }
            alert.setNegativeButton("İptal"){ dialogInterface, i ->
                Toast.makeText(this@MainActivity,"İptal tıklanıldı",Toast.LENGTH_SHORT).show()
            }
            alert.create().show()
        }
    }
}