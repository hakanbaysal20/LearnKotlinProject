package com.hakanbaysal20.myfirstkotlinproject.standartprogramlamayapilari

import java.util.Scanner

fun main() {

    val girdi = Scanner(System.`in`)
    var dersler = Array<String>(5){""}
    var notlar = Array<Int>(5){0}

    for (i in 0 until dersler.count()){
        println("${i+1}. dersi giriniz")
        val ders = girdi.next()
        dersler[i] = ders

        println("${i+1}. notu giriniz")
        val not = girdi.nextInt()
        notlar[i] = not
    }
    var total : Int = 0 // 1. yöntem
    for (i in 0 until notlar.count()){
        println("${dersler[i]} : ${notlar[i]}")
        total += notlar[i]   //1.yöntem
    }
    var ortalama = total / notlar.count() //1.yöntem
    println("Ortalama : $ortalama") // 1. yöntem

  // 2. yöntem
    if (notlar.sum() / notlar.count() < 50){
        println("Kaldınız")
    }else{

        println("Geçtiniz")
    }

}