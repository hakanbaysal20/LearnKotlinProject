package com.hakanbaysal20.tablayoutkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hakanbaysal20.tablayoutkullanimi.databinding.FragmentIkinciBinding


class IkinciFragment : Fragment() {
    private lateinit var binding:FragmentIkinciBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIkinciBinding.inflate(inflater, container, false)

        return binding.root
    }


}