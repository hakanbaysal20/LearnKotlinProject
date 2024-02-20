package com.hakanbaysal20.notesappretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Note(
    @SerializedName("not_id")
    @Expose
    var noteId:Int,
    @SerializedName("ders_adi")
    @Expose
    var lessonName:String,
    @SerializedName("not1")
    @Expose
    var midtermNote:String,
    @SerializedName("not2")
    @Expose
    var finalNote:String

):Serializable