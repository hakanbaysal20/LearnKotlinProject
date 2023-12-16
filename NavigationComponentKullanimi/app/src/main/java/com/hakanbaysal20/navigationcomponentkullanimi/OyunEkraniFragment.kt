package com.hakanbaysal20.navigationcomponentkullanimi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.hakanbaysal20.navigationcomponentkullanimi.databinding.FragmentOyunEkraniBinding


class OyunEkraniFragment : Fragment() {
    private lateinit var binding: FragmentOyunEkraniBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =  FragmentOyunEkraniBinding.inflate(inflater,container,false)
        binding.button3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sonucEkraninaGecis)
        }
        val bundle:OyunEkraniFragmentArgs by navArgs()

        val gelenAd = bundle.ad
        val gelenYas = bundle.yas
        val gelenBoy = bundle.boy
        val gelenBekarMi = bundle.bekarMi
        val gelenKisi = bundle.nesne

        Log.e("ad",gelenAd)
        Log.e("isim",gelenYas.toString())
        Log.e("boy",gelenBoy.toString())
        Log.e("bekar mı ?",gelenBekarMi.toString())
        Log.e("no",gelenKisi.kisi_no.toString())
        Log.e("isim",gelenKisi.kisi_ad.toString())
        return binding.root
    }

}