package com.hakanbaysal20.contactsappretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("kisi_id")
    @Expose
    var personId:Int,
    @SerializedName("kisi_ad")
    @Expose
    var personName:String,
    @SerializedName("kisi_tel")
    @Expose
    var personNo:String
)