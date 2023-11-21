package com.hakanbaysal20.objectorientedprogramming

fun main() {

    infix fun Int.multiply(number:Int):Int {
        return this * number
    }
    val result = 4 multiply 2
    println(result)

}