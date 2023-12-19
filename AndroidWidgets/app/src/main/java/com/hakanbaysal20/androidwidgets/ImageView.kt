package com.hakanbaysal20.androidwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.androidwidgets.databinding.ActivityImageViewBinding
import com.hakanbaysal20.androidwidgets.databinding.ActivityWebViewBinding

class ImageView : AppCompatActivity() {
    private lateinit var binding:ActivityImageViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resim1.setOnClickListener {
            binding.imageView.setImageResource(resources.getIdentifier("ic_android_black_24dp","drawable",packageName))
        }
        binding.resim2.setOnClickListener {
            binding.imageView.setImageResource(resources.getIdentifier("image_view","drawable",packageName))
        }
        binding.gecButton.setOnClickListener {
            val intent = Intent(this@ImageView,VideoView::class.java)
            startActivity(intent)
        }


    }
}