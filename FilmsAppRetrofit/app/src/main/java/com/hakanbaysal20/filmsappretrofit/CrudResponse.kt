package com.hakanbaysal20.filmsappretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CrudResponse(
    @SerializedName("success")
    @Expose
    var success:Int,
    @SerializedName("message")
    @Expose
    var message:String
)