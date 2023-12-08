package com.hakanbaysal20.objectorientedprogramming.interfacea.ornek

open class Elma:Eatable,Sqeezable {
    override fun howToEat() {
        println("Isırılarak")
    }

    override fun howToSqeezable() {
        println("Elma sıkacağı ile")
    }
}