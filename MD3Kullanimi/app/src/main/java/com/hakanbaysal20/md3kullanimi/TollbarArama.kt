package com.hakanbaysal20.md3kullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import com.hakanbaysal20.md3kullanimi.databinding.ActivityTollbarAramaBinding

class TollbarArama : AppCompatActivity(),SearchView.OnQueryTextListener {
    private lateinit var binding:ActivityTollbarAramaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTollbarAramaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar2.title = "Arama"
        setSupportActionBar(binding.toolbar2)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_arama,menu)
        val item = menu.findItem(R.id.actionAra)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.e("onQueryTextChange",newText.toString())
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.e("submit",query.toString())
        return true
    }
}