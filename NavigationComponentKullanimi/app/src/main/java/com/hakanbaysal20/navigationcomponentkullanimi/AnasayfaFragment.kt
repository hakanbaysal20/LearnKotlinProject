package com.hakanbaysal20.navigationcomponentkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.hakanbaysal20.navigationcomponentkullanimi.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {
    private lateinit var binding:FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)
        binding.button2.setOnClickListener {
            val nesne = Kisiler(5555555,"Kazım")
            val gecis = AnasayfaFragmentDirections.oyunEkraninaGecis(nesne,"Hakan",23,1.90f,true)
            Navigation.findNavController(it).navigate(gecis)
        }
        return binding.root
    }

}