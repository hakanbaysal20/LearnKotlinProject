package com.hakanbaysal20.objectorientedprogramming

class Car(var color:String,var speed:Int,var isItWorking:Boolean) {

    var bus:Bus? = null
    lateinit var bus1:Bus // lateinit ile değer vermeden tanımlama yapılır
    // lateinit primitif tiplerde kullanılamaz

    fun run() {
        isItWorking = true
    }
    fun stop() {
        isItWorking = false
    }
    fun speedUp(howManyKm:Int) {
        speed += howManyKm
    }
    fun speedDown(howManyKm: Int) {
        speed -=howManyKm

    }
    fun getInfo(){
        println("Speed : $speed")
        println("Color : $color")
        println("Is it working : $isItWorking")

    }

}