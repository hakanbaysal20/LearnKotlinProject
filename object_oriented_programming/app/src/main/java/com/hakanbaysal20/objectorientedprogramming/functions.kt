package com.hakanbaysal20.objectorientedprogramming

fun main() {

    fun hello(){
        val sonuc = "Hello Hakan"
        println(sonuc)
    }
    hello()
    fun hello1 ():String {
        val sonuc = "Hello Mehmet"
        return sonuc
    }
    val a = hello1()
    println(a)
    fun hello2(isim : String):String {
        val sonuc = "Hello $isim"
        return  sonuc
    }
    val b = hello2("Ahmet")
    println(b)

    fun sum(number1 : Int,number2 : Int): Int {
        val total = number1 + number2
        return total
    }
    val c = sum(24,21)
    println("Total : $c")
    fun sum1(number1:Int,number2:Int) {
        val total = number1 + number2
        println("Total : $total")
        
    }
    sum1(12,9)



}