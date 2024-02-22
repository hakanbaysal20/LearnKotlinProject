package com.hakanbaysal20.filmsappretrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FilmsDAOInterface {

    @GET("filmler/tum_kategoriler.php")
    fun getCategories():Call<CategoryResponse>
    @POST("filmler/filmler_by_kategori_id.php")
    @FormUrlEncoded
    fun getFilmsByCategory(@Field("kategori_id") category:Int):Call<FilmResponse>
}