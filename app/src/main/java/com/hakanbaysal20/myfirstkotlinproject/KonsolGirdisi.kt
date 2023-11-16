package com.hakanbaysal20.myfirstkotlinproject

import java.util.Scanner

fun main(){
    println("Giriniz :")

    val girdi = Scanner(System.`in`) // konsolda boşluk bırakırsanız sadece ilk kelimeyi yazar

    //val ad = girdi.next()

    val sayi = girdi.nextInt()

    println("Sonuç : $sayi")

    var x = 5

    var y = x/0
}