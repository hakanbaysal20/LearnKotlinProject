package com.hakanbaysal20.myfirstkotlinproject.standartprogramlamayapilari

import java.util.Scanner

fun main(){

    println("İsim giriniz : ")
    val girdi = Scanner(System.`in`)
    val isim = girdi.next()
    println("Tekrar sayısı giriniz : ")
    val tekrarSayisi = girdi.nextInt()
    for (i in 1..tekrarSayisi){
        println("For döngüsü : $isim")
    }
    var sayac = 0
    while (sayac < tekrarSayisi){
        println("While döngüsü : $isim")
        sayac ++

    }


}