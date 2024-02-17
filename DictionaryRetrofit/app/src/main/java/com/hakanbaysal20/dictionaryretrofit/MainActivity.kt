package com.hakanbaysal20.dictionaryretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakanbaysal20.dictionaryretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter:CardViewAdapter
    private lateinit var wordList:List<Word>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //toolbar
        setSupportActionBar(binding.toolbar)
        //rv
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)
        getWords()

        //adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_toolbar,menu)
        val item = menu?.findItem(R.id.search_button)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        searchWords(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        searchWords(newText)
        return true
    }
    fun getWords() {
        wordList = ArrayList<Word>()
        val wordIDF = ApiUtils.getWordDAOInterface()
        wordIDF.getWord().enqueue(object :Callback<WordResponse>{
            override fun onResponse(call: Call<WordResponse>, response: Response<WordResponse>) {
                val responseList = response.body().words
                wordList = responseList
                adapter = CardViewAdapter(this@MainActivity,wordList)
                binding.rv.adapter = adapter
            }

            override fun onFailure(call: Call<WordResponse>?, t: Throwable?) {
            }
        }
       )
    }
    fun searchWords(searched:String) {
        wordList = ArrayList<Word>()
        val wordIDF = ApiUtils.getWordDAOInterface()
        wordIDF.searchWord(searched).enqueue(object :Callback<WordResponse>{
            override fun onResponse(call: Call<WordResponse>, response: Response<WordResponse>) {
                val responseList = response.body().words
                wordList = responseList
                adapter = CardViewAdapter(this@MainActivity,wordList)
                binding.rv.adapter = adapter
            }

            override fun onFailure(call: Call<WordResponse>?, t: Throwable?) {

            }
        })
    }
}