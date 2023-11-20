package com.hakanbaysal20.myfirstkotlinproject.standartprogramlamayapilari

fun main() {
    val meyveler = arrayOf<String>("Çilek ", "Muz","Elma","Kivi","Kiraz")

    for (meyve in meyveler){
        println("Meyve : $meyve")
    }
    for ((index,meyve) in meyveler.withIndex()){
        println("$index : $meyve")

    }

}