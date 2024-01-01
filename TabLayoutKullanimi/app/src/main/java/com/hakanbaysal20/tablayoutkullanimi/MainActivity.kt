package com.hakanbaysal20.tablayoutkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.hakanbaysal20.tablayoutkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val fragmentListesi = ArrayList<Fragment>()
    private val fragmentBaslikListesi = ArrayList<String>()
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentListesi.add(BirinciFragment())
        fragmentListesi.add(IkinciFragment())
        fragmentListesi.add(UcuncuFragment())
        val adapter = MyViewPagerAdapter(this)
        binding.viewPager2.adapter = adapter

        fragmentBaslikListesi.add("Bir")
        fragmentBaslikListesi.add("İki")
        fragmentBaslikListesi.add("Üç")
        TabLayoutMediator(binding.tabLayout,binding.viewPager2){ tab,position ->
            tab.setText(fragmentBaslikListesi[position])
        }.attach()
        binding.tabLayout.getTabAt(0,)!!.setIcon(R.drawable.looks_one)
        binding.tabLayout.getTabAt(1)!!.setIcon(R.drawable.looks_two)
        binding.tabLayout.getTabAt(2)!!.setIcon(R.drawable.looks_3)
    }
    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
           return fragmentListesi.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentListesi[position]
        }
    }
}