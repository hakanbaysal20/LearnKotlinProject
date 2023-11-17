package com.hakanbaysal20.myfirstkotlinproject.standartprogramlamayapilari

fun main(){
    for (i in 1..5){
        if (i == 3){ // 3 te döngüyü bitirir
            break
        }
        println("Döngü 1 : $i")
    }
    for (i in 1..5){
        if (i == 3){ // 3 ü pas geçer
            continue
        }
        println("Döngü 2 : $i")
    }
}