package com.hakanbaysal20.filmsappretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Director(
    @SerializedName("yonetmen_id")
    @Expose
    var directorId:Int,
    @SerializedName("yonetmen_ad")
    @Expose
    var directorName:String
)