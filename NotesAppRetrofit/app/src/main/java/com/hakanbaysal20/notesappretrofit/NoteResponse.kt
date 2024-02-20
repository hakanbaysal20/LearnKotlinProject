package com.hakanbaysal20.notesappretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NoteResponse(
    @SerializedName("notlar")
    @Expose
    var notes:List<Note>,
    @SerializedName("success")
    @Expose
    var success:Int
)