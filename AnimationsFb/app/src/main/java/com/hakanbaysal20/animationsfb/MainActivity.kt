package com.hakanbaysal20.animationsfb

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.animationsfb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
     var fabState = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabFirst.scaleX = 0.0f
        binding.fabFirst.scaleY = 0.0f
        binding.fabSecond.scaleY = 0.0f
        binding.fabSecond.scaleX = 0.0f

        binding.fabThird.setOnClickListener {
            scaleAnimation()
        }

    }

    fun scaleAnimation() {
        if (fabState){

            val rotateFabMain = ObjectAnimator.ofFloat(binding.fabThird,"rotation",45.0f,0.0f)
            val scaleFabFirstX = ObjectAnimator.ofFloat(binding.fabFirst,"scaleX",1.0f,0.0f)
            val scaleFabFirstY = ObjectAnimator.ofFloat(binding.fabFirst,"scaleY",1.0f,0.0f)
            val scaleFabSecondX = ObjectAnimator.ofFloat(binding.fabSecond,"scaleX",1.0f,0.0f)
            val scaleFabSecondY = ObjectAnimator.ofFloat(binding.fabSecond,"scaleY",1.0f,0.0f)
            val multipleAnim = AnimatorSet().apply {
                duration = 500
                playTogether(rotateFabMain,scaleFabFirstX,scaleFabFirstY,scaleFabSecondX,scaleFabSecondY)
            }
            multipleAnim.start()
            fabState = false
        }else{
            val rotateFabMain = ObjectAnimator.ofFloat(binding.fabThird,"rotation",0.0f,45.0f)
            val scaleFabFirstX = ObjectAnimator.ofFloat(binding.fabFirst,"scaleX",0.0f,1.0f)
            val scaleFabFirstY = ObjectAnimator.ofFloat(binding.fabFirst,"scaleY",0.0f,1.0f)
            val scaleFabSecondX = ObjectAnimator.ofFloat(binding.fabSecond,"scaleX",0.0f,1.0f)
            val scaleFabSecondY = ObjectAnimator.ofFloat(binding.fabSecond,"scaleY",0.0f,1.0f)
            val multipleAnim = AnimatorSet().apply {
                duration = 500
                playTogether(rotateFabMain,scaleFabFirstX,scaleFabFirstY,scaleFabSecondX,scaleFabSecondY)
            }
            multipleAnim.start()
            fabState = true
        }
    }
}