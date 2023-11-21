package com.hakanbaysal20.objectorientedprogramming

class Calculator {

    //Function overloading
    //aynı isimde fonksiyon oluşturulabilir. fakat parametrelerin sırası ve türü aynı olmamalı
    fun sum(number1:Int,number2:Int) {
        println("Result : ${number1 + number2}")
    }
    fun sum(number1:Double,number2:Int) {
        println("Result : ${number1 + number2}")
    }
    fun sum(number1:Double,number2:Double) {
        println("Result : ${number1 + number2}")
    }
    fun sum(number1:Double,number2:Int,name:String) {
        println("Result : ${number1 + number2}")
    }

}