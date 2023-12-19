package com.hakanbaysal20.androidwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.hakanbaysal20.androidwidgets.databinding.ActivityWebViewBinding

class WebView : AppCompatActivity() {
    private val ulkeler = ArrayList<String>()
    private lateinit var veriAdaptoru:ArrayAdapter<String>
    private lateinit var binding:ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ulkeler.add("Türkiye")
        ulkeler.add("İtalya")
        ulkeler.add("Almanya")
        ulkeler.add("Japonya")
        ulkeler.add("Çin")
        ulkeler.add("Portekiz")
        ulkeler.add("İspanya")
        veriAdaptoru = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,ulkeler)
        binding.spinner.adapter = veriAdaptoru

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://gelecegiyazanlar.turkcell.com.tr")

        binding.gec2.setOnClickListener {
            val intent = Intent(this@WebView,ImageView::class.java)

            startActivity(intent)
        }
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext,"Seçilen Ülke : ${ulkeler[position]}",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        binding.buttonGoster.setOnClickListener {
            Toast.makeText(applicationContext,"Seçilen Ülke : ${ulkeler[binding.spinner.selectedItemPosition]}",Toast.LENGTH_SHORT).show()

        }
    }
}