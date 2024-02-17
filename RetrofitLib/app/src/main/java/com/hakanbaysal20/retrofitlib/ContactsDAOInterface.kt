package com.hakanbaysal20.retrofitlib

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ContactsDAOInterface {

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    fun deleteUser(@Field("kisi_id") person_id:Int):retrofit2.Call<CRUDResponse>
    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    fun addUser(@Field("kisi_ad") person_name:String,
                @Field("kisi_tel") person_no:String):retrofit2.Call<CRUDResponse>
    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    fun updateUser(@Field("kisi_id") person_id:Int,
                   @Field("kisi_ad") person_name:String,
                   @Field("kisi_tel") person_no:String):retrofit2.Call<CRUDResponse>
    @GET("kisiler/tum_kisiler.php")
    fun getContacts():Call<ContactsResponse>
    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    fun searchContacts(@Field("kisi_ad") person_name: String):retrofit2.Call<ContactsResponse>


}