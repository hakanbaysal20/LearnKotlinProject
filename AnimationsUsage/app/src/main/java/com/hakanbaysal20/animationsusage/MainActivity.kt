package com.hakanbaysal20.animationsusage

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import com.hakanbaysal20.animationsusage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      //  binding.imageCloud.visibility = View.INVISIBLE
        buttonInitTranslate(binding.button)
        buttonInitTranslate(binding.textView)
        buttonInitTranslate(binding.imageCloud)
        binding.button.setOnClickListener {
           // alphaAnimation()
         //   scaleAnimation()
          //  rotateAnimation()
         //   translateAnimation()
    //        reverseAnim(binding.imageCloud)
          //  multipleAnimation(100.0f,0.50f)
            seqAnimation()
        }

    }
    fun seqAnimation() {
        val alpha = ObjectAnimator.ofFloat(binding.textView,"alpha",0.0f,1.0f)
        val scaleX = ObjectAnimator.ofFloat(binding.button,"scaleX",50.0f,0.0f)
        val scaleY = ObjectAnimator.ofFloat(binding.imageCloud,"scaleY",50.0f,100.0f)
        val multiple = AnimatorSet().apply {
            duration = 1000
            playSequentially(alpha,scaleY,scaleX)
        }
        multiple.start()
    }
    fun multipleAnimation(start:Float,finish:Float) {
        val rotation = ObjectAnimator.ofFloat(binding.textView,"rotationX",start,finish)
        val scaleX = ObjectAnimator.ofFloat(binding.button,"scaleX",start,finish)
        val scaleY = ObjectAnimator.ofFloat(binding.imageCloud,"scaleY",start,finish)
        val multiple = AnimatorSet().apply {
            duration = 1000
            playTogether(rotation,scaleY,scaleX)
        }
        multiple.start()
    }
    fun reverseAnim(view:View) {
        val rAnim = ObjectAnimator.ofFloat(view,"translationY",0.0f,50.0f).apply {
            duration = 1000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
        rAnim.start()
    }
    fun momentAnim(view:View) {
        val tAnim = ObjectAnimator.ofFloat(view,"translationY",0.0f,300.0f).apply {
            duration = 1000
          //  interpolator = OvershootInterpolator() // ivme verdik
            interpolator = BounceInterpolator() // bounce hareketi
        }
    }
    fun buttonInitTranslate(view:View) {
        val translateAnim = ObjectAnimator.ofFloat(view,"translationX",-800.0f,0.0f).apply {
            duration = 1000
            //    startDelay = 5000  ---> 5 saniye delay verebiliriz
        }
        translateAnim.start()
    }
    fun translateAnimation() {
        val translateAnim = ObjectAnimator.ofFloat(binding.textView,"translationX",0.0f,50.0f).apply {
            duration = 3000
        }
        translateAnim.start()
    }
    fun rotateAnimation() {
        val rotateAnim = ObjectAnimator.ofFloat(binding.textView,"rotation",0.0f,90.0f).apply {
            duration = 3000
        }
        rotateAnim.start()
    }
    fun scaleAnimation() {
        val scaleAnim = ObjectAnimator.ofFloat(binding.imageCloud,"scaleY",1.0f,2.0f).apply {
            duration = 3000
        }
        binding.imageCloud.visibility = View.VISIBLE
        scaleAnim.start()
    }
    fun alphaAnimation() {
        val anim = ObjectAnimator.ofFloat(binding.imageCloud,"alpha",0.0f,1.0f).apply {
            duration = 3000
        }
        binding.imageCloud.visibility = View.VISIBLE
        anim.start()
    }
}