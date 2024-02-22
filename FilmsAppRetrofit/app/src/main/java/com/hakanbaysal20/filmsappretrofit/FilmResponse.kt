package com.hakanbaysal20.filmsappretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FilmResponse(
    @SerializedName("filmler")
    @Expose
    var filmList : List<Film>,
    @SerializedName("success")
    @Expose
    var success:Int
)