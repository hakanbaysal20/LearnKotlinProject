package com.hakanbaysal20.collections

import java.util.ArrayList


fun main() {
    val meyveler = ArrayList<String>()
    meyveler.add("Muz")
    meyveler.add("Çilek")
    meyveler.add("Kiraz")
    meyveler.add("Elma")
    meyveler.add("Kivi")
    var str = meyveler.get(2)
    println(str)

    for (meyve in 0 until  meyveler.size){
        println(meyveler.get(meyve))
    }

    meyveler.add("Mandalina")
    println(meyveler.toString())
    meyveler[2] = "Ananas"
    println(meyveler.toString())
    meyveler.add(2, element = "Portakal") // 2. indekse portakal eklenir ve sonrasındaki itemler sağa kayar (2 3 olur , 3 4 olur vs.)
    println(meyveler.toString())
}