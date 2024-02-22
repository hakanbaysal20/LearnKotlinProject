package com.hakanbaysal20.filmsappretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hakanbaysal20.filmsappretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var categoryList:List<Category>
    private lateinit var filmList : List<Film>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCategories()
        getFilmsByCategory(4)
    }
    fun getFilmsByCategory(categoryId:Int) {
        filmList = ArrayList<Film>()
        val filmIDF = ApiUtils.getFilmDAOInterface()
        filmIDF.getFilmsByCategory(categoryId).enqueue(object : Callback<FilmResponse>{
            override fun onResponse(call: Call<FilmResponse>, response: Response<FilmResponse>) {
                val responseList = response.body().filmList
                filmList = responseList
                for (i in filmList){
                    Log.e("eeeeeeeeeeeeee",i.category.categoryName)
                }
            }
            override fun onFailure(call: Call<FilmResponse>?, t: Throwable?) {
            }
        })
    }
    fun getCategories() {
        val filmIDF = ApiUtils.getFilmDAOInterface()
        categoryList = ArrayList<Category>()
        filmIDF.getCategories().enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(
                call: Call<CategoryResponse>,
                response: Response<CategoryResponse>
            ) {
                val responseList = response.body().categories
                categoryList = responseList    // dönen cevap
                for (i in categoryList){
                    Log.e("addsasd",i.categoryName)
                    Log.e("asdads",i.categoryId.toString())
                }
            }
            override fun onFailure(call: Call<CategoryResponse>?, t: Throwable?) {

            }
        })
    }
}