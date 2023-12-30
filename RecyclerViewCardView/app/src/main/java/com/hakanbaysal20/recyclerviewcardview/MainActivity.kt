package com.hakanbaysal20.recyclerviewcardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hakanbaysal20.recyclerviewcardview.databinding.ActivityMainBinding
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var list:ArrayList<Ulkeler>
    private lateinit var adapter:RVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(applicationContext)
    //    binding.rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
       // binding.rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)
        list = ArrayList<Ulkeler>()
        val turkiye = Ulkeler(1,"Türkiye")
        val almanya = Ulkeler(2,"Almanya")
        val belcika = Ulkeler(3,"Belçika")
        val fransa = Ulkeler(4,"Fransa")
        val ingiltere = Ulkeler(5,"İngiltere")
        val rusya = Ulkeler(6,"Rusya")
        val macaristan = Ulkeler(7,"Macaristan")

        adapter = RVAdapter(this,list)
        binding.rv.adapter = adapter
        list.add(turkiye)
        list.add(almanya)
        list.add(belcika)
        list.add(fransa)
        list.add(ingiltere)
        list.add(rusya)
        list.add(macaristan)



    }
}