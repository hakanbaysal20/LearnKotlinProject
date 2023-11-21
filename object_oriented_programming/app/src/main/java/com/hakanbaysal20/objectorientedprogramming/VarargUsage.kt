package com.hakanbaysal20.objectorientedprogramming

fun main() {
    //vararg parametresi dizi gibi davranır ve istediğimiz kadar yazılan parametreye değer göndermemizi sağlar.
    fun sum(vararg numbers:Int):Int {
        var result = 0
        for (i in numbers){
            result += i
        }

        return result
    }

    val result = sum(1,2,3,4,5,6,-1,-2,-3,-4,-5,-6)
    println("Result : $result")
}