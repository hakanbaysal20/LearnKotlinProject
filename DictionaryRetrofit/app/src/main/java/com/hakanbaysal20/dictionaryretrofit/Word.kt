package com.hakanbaysal20.dictionaryretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Word(
    @SerializedName("kelime_id")
    @Expose
    var wordId:Int,
    @SerializedName("ingilizce")
    @Expose
    var mainWord:String,
    @SerializedName("turkce")
    @Expose
    var translateWord:String):Serializable {
}