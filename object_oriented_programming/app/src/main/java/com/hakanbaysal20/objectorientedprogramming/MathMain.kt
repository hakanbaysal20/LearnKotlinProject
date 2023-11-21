package com.hakanbaysal20.objectorientedprogramming

fun main() {
    val math = Math()

    math.sum(21,90)
    val result = math.subtraction(30.0,23.0)
    println("Result : $result")
    math.multiplication(3,120)
    math.divide(360,120,"Hakan")
    val result1 = math.divide1(20,5)
    println(result1)
}