package com.hakanbaysal20.bayrakquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.hakanbaysal20.bayrakquiz.databinding.FragmentResultPageBinding


class ResultPage : Fragment() {
    private lateinit var binding:FragmentResultPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultPageBinding.inflate(inflater,container,false)
        val bundle:ResultPageArgs by navArgs()
        binding.textResult.text = "Doğru Sayısı:${bundle.correctAnswer} \n  Yanlış Sayısı:${bundle.incorrectAnswer}"
        val rate = bundle.correctAnswer * 20
        binding.textPercent.text = "%$rate başarı"
        return binding.root
    }
}