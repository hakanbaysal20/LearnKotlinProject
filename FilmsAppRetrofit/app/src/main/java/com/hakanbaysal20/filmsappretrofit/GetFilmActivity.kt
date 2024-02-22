package com.hakanbaysal20.filmsappretrofit

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.hakanbaysal20.filmsappretrofit.databinding.ActivityGetFilmBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetFilmActivity : AppCompatActivity() {
    private lateinit var binding:ActivityGetFilmBinding
    private lateinit var filmList:List<Film>
    private lateinit var adapter: FilmCardViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val categoryId = intent.getIntExtra("categoryId",0)
        binding.filmRV.setHasFixedSize(true)
        binding.filmRV.layoutManager = GridLayoutManager(this,2)
        getFilmsByCategory(categoryId)
        setSupportActionBar(binding.filmToolbar)
    }
    fun getFilmsByCategory(categoryId:Int) {
        filmList = ArrayList<Film>()
        val filmIDF = ApiUtils.getFilmDAOInterface()
        filmIDF.getFilmsByCategory(categoryId).enqueue(object : Callback<FilmResponse> {
            override fun onResponse(call: Call<FilmResponse>, response: Response<FilmResponse>) {
                val responseList = response.body().filmList
                filmList = responseList
                for (i in filmList){
                    Log.e("eeeeeeeeeeeeee",i.category.categoryName)
                }
                adapter = FilmCardViewAdapter(this@GetFilmActivity,filmList)
                binding.filmRV.adapter = adapter
                binding.filmToolbar.setTitle(filmList.first().category.categoryName)
                binding.filmToolbar.setTitleTextColor(Color.WHITE)
            }
            override fun onFailure(call: Call<FilmResponse>?, t: Throwable?) {
            }
        })
    }
}