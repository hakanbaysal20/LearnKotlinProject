package com.hakanbaysal20.myfirstkotlinproject.standartprogramlamayapilari

fun main(){
    val gun = 3
    when(gun){
        1 -> println("Pazartesi")
        2 -> println("Salı")
        3 -> println("Çarşamba")
        4 -> println("Perşembe")
        5 -> println("Cuma")
        6 -> println("Cumartesi")
        7 -> println("Pazar")
        else -> println("Böyler bir gün yok")
    }

}