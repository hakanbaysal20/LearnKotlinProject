package com.hakanbaysal20.filmsappretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Film(
    @SerializedName("film_id")
    @Expose
    var filmId:Int,
    @SerializedName("film_ad")
    @Expose
    var filmName:String,
    @SerializedName("film_yil")
    @Expose
    var filmYear:String,
    @SerializedName("film_resim")
    @Expose
    var filmImage:String,
    @SerializedName("kategori")
    @Expose
    var category:Category,
    @SerializedName("yonetmen")
    @Expose
    var director:Director
):Serializable