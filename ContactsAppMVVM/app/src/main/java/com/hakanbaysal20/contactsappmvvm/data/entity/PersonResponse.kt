package com.hakanbaysal20.contactsappmvvm.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PersonResponse(
    @SerializedName("kisiler")
    @Expose
    var contactsList:List<Person>,
    @SerializedName("success")
    @Expose
    var success:Int
)