package com.hakanbaysal20.retrofitlib

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ContactsResponse(
    @SerializedName("kisiler")
    @Expose
    var contacts:List<Contacts>,
    @SerializedName("success")
    @Expose
    var success:Int) {
}