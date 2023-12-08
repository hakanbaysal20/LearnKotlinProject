package com.hakanbaysal20.objectorientedprogramming.compositions

import com.hakanbaysal20.objectorientedprogramming.Adress

fun main() {
    val adress = Adress("Bursa","Osmangazi")
    val person = Persons1("Hakan","18",adress)
    println("Person name     : ${person.name}")
    println("Person age      : ${person.age}")
    println("Person city     : ${person.adress.city}")
    println("Person district : ${person.adress.district}")
}