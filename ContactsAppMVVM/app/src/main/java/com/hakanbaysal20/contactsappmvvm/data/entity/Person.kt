package com.hakanbaysal20.contactsappmvvm.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Person(
    @SerializedName("kisi_id")
    @Expose
    var personId:Int,
    @SerializedName("kisi_ad")
    @Expose
    var personName:String,
    @SerializedName("kisi_tel")
    @Expose
    var personNumber:String):Serializable
