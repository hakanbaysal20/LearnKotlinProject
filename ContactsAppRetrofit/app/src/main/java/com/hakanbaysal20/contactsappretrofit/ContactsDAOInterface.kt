package com.hakanbaysal20.contactsappretrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ContactsDAOInterface {

    @GET("kisiler/tum_kisiler.php")
    fun getContacts():Call<PersonResponse>
    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    fun addPerson(@Field("kisi_ad") personName:String,@Field("kisi_tel") personNo:String): Call<CRUDResponse>
    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    fun updatePerson(@Field("kisi_id") personId:Int,@Field("kisi_ad") personName:String,@Field("kisi_tel") personNo:String):Call<CRUDResponse>
    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    fun deletePerson(@Field("kisi_id") personId:Int):Call<CRUDResponse>
}