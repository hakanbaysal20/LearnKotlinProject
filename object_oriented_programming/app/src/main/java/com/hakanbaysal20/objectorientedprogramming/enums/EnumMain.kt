package com.hakanbaysal20.objectorientedprogramming.enums

fun main() {

    fun getFee(size: TinSize) {
        when (size){
            TinSize.Small -> println(20*30)
            TinSize.Medium -> println(30*30)
            TinSize.Large -> println(40*30)

        }
    }
    getFee(TinSize.Medium)
    getFee(TinSize.Large)
    getFee(TinSize.Small)
}