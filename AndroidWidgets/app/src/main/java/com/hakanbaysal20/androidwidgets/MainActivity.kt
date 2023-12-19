package com.hakanbaysal20.androidwidgets

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.inputmethodservice.KeyboardView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import com.hakanbaysal20.androidwidgets.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val text = binding.editTextText.text.toString()
            binding.textView.text = text
            val number = binding.editTextText2.text.toString()
            binding.textView2.text = number
        }
        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                Log.e("Switch","On")

            }else{
                Log.e("Switch","Off")
            }
        }
        binding.durum.setOnClickListener {
            val dartDurum = binding.checkBox.isChecked
            val javaDurum = binding.checkBox2.isChecked
            val barcelonaDurum = binding.Barcelona.isChecked
            val realMadridDurum = binding.realMadrid.isChecked
            val ratingDurum = binding.ratingBar.rating.toString()
            val sliderDurum = binding.slider.progress.toString()
            Log.e("Dart",dartDurum.toString())
            Log.e("Java",javaDurum.toString())
            Log.e("Barcelona",barcelonaDurum.toString())
            Log.e("Real Madrid",realMadridDurum.toString())
            Log.e("Rating Bar",ratingDurum)
            Log.e("Slider",sliderDurum)
        }
        binding.Barcelona.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                Toast.makeText(this,"Barcelonaaaaa",Toast.LENGTH_SHORT).show()
            }
        }
        binding.gec.setOnClickListener {
            val intent = Intent(this@MainActivity,WebView::class.java)
            startActivity(intent)
        }
        binding.progressOn.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
        }
        binding.progressOff.setOnClickListener {
            binding.progressBar.visibility = View.INVISIBLE
        }
        binding.editTextSaat.setOnClickListener {
            val calendar = Calendar.getInstance()
            val saat = calendar.get(Calendar.HOUR_OF_DAY)
            val dakika = calendar.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                binding.editTextSaat.setText("$hourOfDay : $minute")
            },saat,dakika,true)
            timePicker.setTitle("Saat Seçiniz")
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE,"Ayarla",timePicker)
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İptal",timePicker)
            timePicker.show()
        }
        binding.editTextTarih.setOnClickListener {
            val calendar = Calendar.getInstance()
            val gun = calendar.get(Calendar.DAY_OF_MONTH)
            val yil = calendar.get(Calendar.YEAR)
            val ay = calendar.get(Calendar.MONTH)
            val datePicker = DatePickerDialog(this@MainActivity,DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->

                binding.editTextTarih.setText("$gun/${ay+1}/$yil")
            },yil,ay,gun)
            datePicker.setTitle("Tarih Seçiniz")
            datePicker.setButton(DialogInterface.BUTTON_POSITIVE,"Ayarla",datePicker)
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İptal",datePicker)
            datePicker.show()
        }
        binding.slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.sliderText.text = "Sonuç : $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }
}