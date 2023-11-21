package com.hakanbaysal20.objectorientedprogramming

fun main() {
    val kamilKoc = Bus(24,"Isparta","İzmir",20)

    kamilKoc.getInfo()
    kamilKoc.takePassenger(3)
    kamilKoc.getInfo()
    kamilKoc.takeDownPassenger(8)
    kamilKoc.getInfo()

    val  pamukkale = Bus(30,"İstanbul","İzmir",21)
    pamukkale.getInfo()

}