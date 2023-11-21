package com.hakanbaysal20.objectorientedprogramming

class Homework {

    fun transformation(degree:Double):Double {
        val fahrenhiet = (degree * 1.8) + 32
        return fahrenhiet
    }
    fun perimeter(long:Int,short:Int){
        val result = (long * 2) + (short * 2)
        println("Result : $result")
    }
    fun factorial(number:Int):Int {
        var fact = 1
        for (i in 1 ..  number){
            fact *= i
        }
        return fact
    }
    fun numberOfLetters(word:String,letter:Char) {
        var result = 0
        for (w in word){
            if (letter == w){
                result ++
            }
        }
        println("Number of letter : $result")
    }
    fun sumOfInteriorAngels(side:Int):Int {
        val result = (side - 2) * 180
        return result
    }
    fun salaryCount(day:Int):Int {
        val workingHours = day * 8
        var result = 0
        if (workingHours <= 160){
            result = workingHours * 10
        }else{
            result = (160 * 10) + ((workingHours - 160) * 20)
        }
        return result
    }
    fun internetFee(gb:Int):Int {
        var result = 0
        if (gb <= 50){
            result = 100
        }else{
            result = 100 + ((gb - 50) * 4)
        }

        return result
    }
}