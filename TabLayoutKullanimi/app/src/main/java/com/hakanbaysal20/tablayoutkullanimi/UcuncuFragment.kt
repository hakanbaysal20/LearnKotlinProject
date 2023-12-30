package com.hakanbaysal20.tablayoutkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hakanbaysal20.tablayoutkullanimi.databinding.FragmentUcuncuBinding


class UcuncuFragment : Fragment() {
    private lateinit var binding:FragmentUcuncuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUcuncuBinding.inflate(inflater, container, false)
        return binding.root
    }

}