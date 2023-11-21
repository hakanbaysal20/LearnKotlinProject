package com.hakanbaysal20.objectorientedprogramming.composition.database

class Films(var film_id:Int,
            var film_name:String,
            var film_year:Int,
            var categories: Categories,
            var directors: Directors) {

}