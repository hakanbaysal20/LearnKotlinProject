package com.hakanbaysal20.filmsappretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakanbaysal20.filmsappretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var categoryList:List<Category>
    private lateinit var adapter: CategoryCardViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.categorRV.setHasFixedSize(true)
        binding.categorRV.layoutManager = LinearLayoutManager(this)

        getCategories()
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
                categoryList = responseList
                for (i in categoryList){
                    Log.e("addsasd",i.categoryName)
                    Log.e("asdads",i.categoryId.toString())
                }
                adapter = CategoryCardViewAdapter(this@MainActivity ,categoryList)
                binding.categorRV.adapter = adapter
            }
            override fun onFailure(call: Call<CategoryResponse>?, t: Throwable?) {

            }
        })
    }
}