package com.hakanbaysal20.objectorientedprogramming

fun main() {
   val bmw = Car("red",90,false)
 bmw.getInfo()
 bmw.speed = 95
 bmw.color = "black"
 bmw.isItWorking = true
 bmw.getInfo()
 bmw.run()
 bmw.getInfo()
 bmw.stop()
 bmw.getInfo()
 bmw.speedUp(50)
 bmw.getInfo()
 bmw.speedDown(30)
 bmw.getInfo()
 val sahin = Car("Yellow",50,false)
 sahin.speedUp(30)
 sahin.run()
 sahin.getInfo()
}