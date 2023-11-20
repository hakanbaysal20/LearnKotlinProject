package com.hakanbaysal20.myfirstkotlinproject.standartprogramlamayapilari

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

fun main() {

    for (i in 0 until 10){
        val rastgeleSayi = Random.nextInt(0,10) // 0 ile 9 arasında rastgele sayı !! 10 dahil değil (until)
        println(rastgeleSayi)

    }
    val c = ceil(6.5) // yukarı yuvarlar 7
    println("c : $c")
    val f = floor(6.5) // aşağı yuvarlar 6
    println("f : $f")
    val s = sqrt(4.0) // karekök alır
    println("s : $s")
    val a = abs(-10) // mutlak değer
    println("a : $a")
    val mx = max(100,200) // girilen 2 değerden maximumu verir.
    println("max : $mx")
    val mn = min(100,200) // girilen 2 değerden minimumu verir.
    println("min : $mn")
    val p = 2.0.pow(3.0) // üslü sayılar.
    println("p : $p")

}