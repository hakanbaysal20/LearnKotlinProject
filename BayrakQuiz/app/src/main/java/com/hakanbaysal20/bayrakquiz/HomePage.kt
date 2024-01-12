package com.hakanbaysal20.bayrakquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.hakanbaysal20.bayrakquiz.databinding.FragmentHomePageBinding

class HomePage : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater,container,false)
        binding.buttonStart2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.gamePage)
        }

        return binding.root
    }

}