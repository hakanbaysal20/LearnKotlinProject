package com.hakanbaysal20.androidwidgets

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.androidwidgets.databinding.ActivityVideoViewBinding

class VideoView : AppCompatActivity() {
    private lateinit var binding:ActivityVideoViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.basla.setOnClickListener {
            val path = Uri.parse("android.resource://"+packageName+"/"+R.raw.galiba)
            binding.videoView2.setVideoURI(path)
            binding.videoView2.start()
        }
        binding.durdur.setOnClickListener {
            binding.videoView2.stopPlayback()
        }
    }

}