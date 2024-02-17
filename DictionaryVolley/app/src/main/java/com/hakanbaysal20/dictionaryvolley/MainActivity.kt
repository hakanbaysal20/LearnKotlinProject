package com.hakanbaysal20.dictionaryvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.hakanbaysal20.dictionaryvolley.databinding.ActivityMainBinding
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener {
    private lateinit var binding:ActivityMainBinding
    private lateinit var wordList:ArrayList<Word>
    private lateinit var adapter:WordAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)
        getWords()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search,menu)
        val item = menu?.findItem(R.id.search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }
    fun getWords(){
        val baseUrl = "http://kasimadalan.pe.hu/sozluk/tum_kelimeler.php"
        wordList = ArrayList()
        val request = StringRequest(Request.Method.GET,baseUrl, Response.Listener { response ->
            Log.e("Success","Successfuly")
            try {

                val jsonObject = JSONObject(response)
                val words = jsonObject.getJSONArray("kelimeler")
                for (i in 0 until words.length()){
                    val word = words.getJSONObject(i)
                    val newWord = Word(word.getInt("kelime_id"),word.getString("ingilizce"),word.getString("turkce"))
                    wordList.add(newWord)
                    Log.e("asdad00",word.getString("ingilizce"))
                }

                adapter = WordAdapter(this@MainActivity,wordList)
                binding.rv.adapter = adapter


            }catch (e: JSONException){
                e.printStackTrace()

            }
        }, Response.ErrorListener { error ->

        })
        Volley.newRequestQueue(this).add(request)
    }
    fun searchWords(searchWord:String) {
        val baseUrl = "http://kasimadalan.pe.hu/sozluk/kelime_ara.php"
        wordList = ArrayList()
        val request = object : StringRequest(Method.POST,baseUrl,Response.Listener { response ->
            try {
                val jsonObject = JSONObject(response)
                val words = jsonObject.getJSONArray("kelimeler")
                for (i in 0 until words.length()){
                    val word = words.getJSONObject(i)
                    val newWord = Word(word.getInt("kelime_id"),word.getString("ingilizce"),word.getString("turkce"))
                    Log.e("asdasd",word.getString("ingilizce"))
                    wordList.add(newWord)
                }
                adapter = WordAdapter(this@MainActivity,wordList)
                binding.rv.adapter = adapter

            }catch (e:JSONException){
                e.printStackTrace()
            }
        },Response.ErrorListener {error ->   }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["ingilizce"] = searchWord
                return params
            }
        }
        Volley.newRequestQueue(this).add(request)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
      searchWords(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        searchWords(newText)
        return true
    }
}