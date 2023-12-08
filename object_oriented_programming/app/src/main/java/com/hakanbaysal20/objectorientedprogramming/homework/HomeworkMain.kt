package com.hakanbaysal20.objectorientedprogramming.homework

fun main() {

    val homework = Homework()
    val degree = homework.transformation(10.0)
    println(degree)
    homework.perimeter(5,10)
    val result =  homework.factorial(10)
    println("Factorial : $result")
    homework.numberOfLetters("Ankara",'A')
    val result1 = homework.sumOfInteriorAngels(4)
    println(result1)
    val salary = homework.salaryCount(19)
    println(salary)
    val fee =homework.internetFee(51)
    println(fee)
}