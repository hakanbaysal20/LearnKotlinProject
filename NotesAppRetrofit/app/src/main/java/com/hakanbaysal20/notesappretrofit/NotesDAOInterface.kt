package com.hakanbaysal20.notesappretrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface NotesDAOInterface {

    @GET("notlar/tum_notlar.php")
    fun getNotes():Call<NoteResponse>
    @POST("notlar/insert_not.php")
    @FormUrlEncoded
    fun addNotes(@Field("ders_adi") lessonName:String , @Field("not1") midtermNote:String, @Field("not2") finalNote:String):Call<CRUDResponse>
    @POST("notlar/delete_not.php")
    @FormUrlEncoded
    fun deleteNotes(@Field("not_id") notId:Int):Call<CRUDResponse>
    @POST("notlar/update_not.php")
    @FormUrlEncoded
    fun updateNotes(@Field("not_id") notId:String,@Field("ders_adi") lessonName: String,@Field("not1") midtermNote:String,@Field("not2") finalNote:String):Call<CRUDResponse>
}