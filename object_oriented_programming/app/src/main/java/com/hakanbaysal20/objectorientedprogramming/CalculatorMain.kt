package com.hakanbaysal20.objectorientedprogramming

fun main() {
    val math = Calculator()
    math.sum(20,30)
    math.sum(100.0,30)
    math.sum(20.0,21.0)
    math.sum(80.0,22,"Hakan")
}