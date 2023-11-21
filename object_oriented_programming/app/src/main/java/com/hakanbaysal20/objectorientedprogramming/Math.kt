package com.hakanbaysal20.objectorientedprogramming

class Math {

    fun sum(number1 : Int ,number2: Int) {

        val result = number1 + number2
        println("Result : $result")
    }
    fun subtraction(number1: Double,number2: Double):Double {
        val result = number1 - number2
        return result
    }
    fun multiplication(number1: Int,number2: Int) {
        val result = number1 * number2
        println("Result : $result")
    }
    fun divide(number1: Int,number2: Int,name:String) {
        val result = number1 / number2
        println("Result : $result -  $name")

    }
    fun divide1(number1: Int,number2: Int) : String {
        return  "Result : ${number1 / number2}"
    }


}