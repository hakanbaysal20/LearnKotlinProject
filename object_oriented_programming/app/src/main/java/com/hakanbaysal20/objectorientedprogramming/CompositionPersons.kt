package com.hakanbaysal20.objectorientedprogramming

fun main() {
    val adress = Adress("Bursa","Osmangazi")
    val person = Persons1("Hakan","18",adress)
    println("Person name     : ${person.name}")
    println("Person age      : ${person.age}")
    println("Person city     : ${person.adress.city}")
    println("Person district : ${person.adress.district}")
}