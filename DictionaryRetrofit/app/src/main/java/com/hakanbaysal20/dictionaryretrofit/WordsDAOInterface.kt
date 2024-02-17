package com.hakanbaysal20.dictionaryretrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface WordsDAOInterface {
    @GET("sozluk/tum_kelimeler.php")
    fun getWord():Call<WordResponse>
    @POST("sozluk/kelime_ara.php")
    @FormUrlEncoded
    fun searchWord(@Field("ingilizce") word:String):Call<WordResponse>
}