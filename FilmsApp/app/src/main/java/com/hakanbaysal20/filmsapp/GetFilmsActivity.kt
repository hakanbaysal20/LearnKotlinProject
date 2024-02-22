package com.hakanbaysal20.filmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.hakanbaysal20.filmsapp.databinding.ActivityGetFilmsBinding
import org.json.JSONException
import org.json.JSONObject

class GetFilmsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityGetFilmsBinding
    private lateinit var filmList : ArrayList<Film>
    private lateinit var adapter:FilmCardViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetFilmsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val categoryId = intent.getIntExtra("categoryId",0)
        Log.e("",categoryId.toString())
        binding.getFilmsRV.setHasFixedSize(true)
        binding.getFilmsRV.layoutManager = GridLayoutManager(this,2)
        getFilmsByCategory(categoryId.toString())

    }
    fun getFilmsByCategory(categoryId:String) {
        filmList = ArrayList<Film>()
        val baseUrl = "http://kasimadalan.pe.hu/filmler/filmler_by_kategori_id.php"
        val request = object : StringRequest(Request.Method.POST,baseUrl,Response.Listener { response ->
            try {
                val jsonObject = JSONObject(response)
                val responseList = jsonObject.getJSONArray("filmler")
                for (i in 0 until responseList.length()){
                    val responseFilm = responseList.getJSONObject(i)
                    val responseCategory = (responseList.getJSONObject(i).getJSONObject("kategori"))
                    val responseDirector = responseList.getJSONObject(i).getJSONObject("yonetmen")
                    val category = Category(responseCategory.getInt("kategori_id"),responseCategory.getString("kategori_ad"))
                    val director = Director(responseDirector.getInt("yonetmen_id"),responseDirector.getString("yonetmen_ad"))
                    val film = Film(
                        responseFilm.getInt("film_id"),
                        responseFilm.getString("film_ad"),
                        responseFilm.getString("film_yil"),
                        responseFilm.getString("film_resim"),
                        director,
                        category)
                    filmList.add(film)
                    Log.e("adsasdasd",film.filmName)
                }
                adapter = FilmCardViewAdapter(this,filmList)
                binding.getFilmsRV.adapter = adapter

            }catch (e: JSONException){
                e.printStackTrace()
            }
        }, Response.ErrorListener { error -> error.printStackTrace()  }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["kategori_id"] = categoryId
                return params
            }
        }
        Volley.newRequestQueue(this).add(request)
    }
}
