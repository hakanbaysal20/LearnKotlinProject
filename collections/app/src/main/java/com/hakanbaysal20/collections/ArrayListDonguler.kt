package com.hakanbaysal20.collections

import java.util.ArrayList

fun main() {
    val meyveler = ArrayList<String>()
    meyveler.add("Muz")
    meyveler.add("Çilek")
    meyveler.add("Kiraz")
    meyveler.add("Elma")
    meyveler.add("Kivi")
    for (meyve in meyveler){
        println("Meyve : $meyve")
    }
    for ((index, meyve) in meyveler.withIndex()){
        println("${index + 1}. meyve : $meyve")
    }
}