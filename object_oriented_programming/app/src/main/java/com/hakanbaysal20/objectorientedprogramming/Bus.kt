package com.hakanbaysal20.objectorientedprogramming

class Bus(var capacity:Int, var fromWhere:String, var toWhere:String,var currentPassenger:Int) {

    fun getInfo() {
        println("Capacity          : $capacity")
        println("From Where        : $fromWhere")
        println("Capacity          : $toWhere")
        println("Current Passenger : $currentPassenger")

    }
    fun takePassenger(howMany:Int) {
        currentPassenger += howMany
    }
    fun takeDownPassenger(howMany: Int) {
        currentPassenger -= howMany
        
    }

}