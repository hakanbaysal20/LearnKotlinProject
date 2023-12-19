package com.hakanbaysal20.androidwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import com.hakanbaysal20.androidwidgets.databinding.ActivityMainBinding

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
        binding.progressOn.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
        }
        binding.progressOff.setOnClickListener {
            binding.progressBar.visibility = View.INVISIBLE
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