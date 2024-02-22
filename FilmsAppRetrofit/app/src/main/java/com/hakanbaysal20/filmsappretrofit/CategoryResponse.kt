package com.hakanbaysal20.filmsappretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CategoryResponse(
    @SerializedName("kategoriler")
    @Expose
    var categories:List<Category>,
    @SerializedName("success")
    @Expose
    var success:Int
    )