package com.hakanbaysal20.filmsappretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category(
    @SerializedName("kategori_id")
    @Expose
    var categoryId:Int,
    @SerializedName("kategori_ad")
    @Expose
    var categoryName:String
):Serializable