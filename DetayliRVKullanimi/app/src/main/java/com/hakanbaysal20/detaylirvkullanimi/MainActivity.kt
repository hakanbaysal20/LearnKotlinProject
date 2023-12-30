package com.hakanbaysal20.detaylirvkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hakanbaysal20.detaylirvkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var adapter:RVAdapter
    private lateinit var binding:ActivityMainBinding
    private lateinit var filmler:ArrayList<Films>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val django = Films("Django","django",15)
        val birZamanlarAnadoluda = Films("Bir Zamanlar Anadoluda","birzamanlaranadoluda",40)
        val inception = Films("Inception","inception",30)
        val interstellar = Films("Interstellar","interstellar",25)
        val thePianist = Films("The Pianist","thepianist",30)
        val theHatefulEight = Films("The Hateful Eight","thehatefuleight",20)
        filmler = ArrayList<Films>()
        filmler.add(django)
        filmler.add(birZamanlarAnadoluda)
        filmler.add(inception)
        filmler.add(interstellar)
        filmler.add(thePianist)
        filmler.add(theHatefulEight)
        adapter = RVAdapter(this,filmler)
        binding.recyclerView.adapter = adapter
    }
}