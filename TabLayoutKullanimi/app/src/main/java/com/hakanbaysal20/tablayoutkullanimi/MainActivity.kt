package com.hakanbaysal20.tablayoutkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hakanbaysal20.tablayoutkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val fragmentListesi = ArrayList<Fragment>()
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentListesi.add(BirinciFragment())
        fragmentListesi.add(IkinciFragment())
        fragmentListesi.add(UcuncuFragment())
    }
    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
           return fragmentListesi.size
        }

        override fun createFragment(position: Int): Fragment {
        }


    }
}