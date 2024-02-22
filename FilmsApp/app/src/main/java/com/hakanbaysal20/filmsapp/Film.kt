package com.hakanbaysal20.filmsapp

import java.io.Serializable

data class Film(var filmId:Int,var filmName:String,var filmYear:String,var filmImage:String,var filmDirector:Director,var category:Category):Serializable