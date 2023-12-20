package com.hakanbaysal20.getircloneapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.hakanbaysal20.getircloneapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.Runnable
import kotlin.math.abs


class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var handler:Handler
    private lateinit var imageList:ArrayList<Int>
    private lateinit var adapter:ImageAdapter
    private lateinit var viewPager2:ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }


}