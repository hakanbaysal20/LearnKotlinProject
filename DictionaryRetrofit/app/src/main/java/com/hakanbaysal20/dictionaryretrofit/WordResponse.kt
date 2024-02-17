package com.hakanbaysal20.dictionaryretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WordResponse(
    @SerializedName("kelimeler")
    @Expose
    var words:List<Word>,
    @SerializedName("success")
    @Expose
    var success:Int
) {

}