package com.hakanbaysal20.collections.exception

fun main() {

    val x = 10
    val y = 0

    val dizi = Array<Int>(2){0} // {0,0}


  //  println("Sonuç : ${x/y}") // exception hatası verecektir. 0 a bölünme olmaz

    try {
        println("Sonuç: ${x/y}")
        println("İşlem tamam")
        dizi[4] = 8
    }catch (e:ArithmeticException){
            println("İkinci sayı sıfıra bölünmez")

    }
    catch (e:ArrayIndexOutOfBoundsException){
        println("Dizi boyutunu aştınız")

    }
}