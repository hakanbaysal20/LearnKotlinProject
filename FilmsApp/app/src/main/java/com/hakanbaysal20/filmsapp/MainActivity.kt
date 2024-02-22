package com.hakanbaysal20.filmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.hakanbaysal20.filmsapp.databinding.ActivityMainBinding
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: CategoryCardViewAdapter
    private lateinit var categoryList:ArrayList<Category>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCategories()
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)
    }
    fun getCategories() {
        categoryList = ArrayList()
        val baseUrl = "http://kasimadalan.pe.hu/filmler/tum_kategoriler.php"
        val request = StringRequest(Request.Method.GET,baseUrl, Response.Listener { response ->
            try {
                val jsonObject =JSONObject(response)
                val categories =jsonObject.getJSONArray("kategoriler")
                for (i in 0 until categories.length()){
                    val responseCategory = categories.getJSONObject(i)
                    val category = Category(responseCategory.getInt("kategori_id"),responseCategory.getString("kategori_ad"))
                    categoryList.add(category)
                }
                adapter = CategoryCardViewAdapter(this,categoryList)
                binding.rv.adapter = adapter

            }catch (e:JSONException){
                e.printStackTrace()
            }
        },Response.ErrorListener {error -> error.printStackTrace()  })
        Volley.newRequestQueue(this).add(request)
    }
}