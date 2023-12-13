package com.hakanbaysal20.collections.string

import java.util.Scanner

fun main() {

    val girdi = Scanner(System.`in`)
    println("Kelime giriniz")
    val kelime = girdi.next()

    for (i in kelime.reversed()){
        print(i)
    } // tersten yazdırma
    println("************")

    // or
    for (i in kelime.length -1 downTo 0){ // indeks için -1
        print(kelime[i])
    }
}