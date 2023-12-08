package com.hakanbaysal20.objectorientedprogramming.interfacea

class Interface2:Interface1 {    // interface'de bütün özellikler kullanılmak zorunda

    override val degisken: Int = 10
    override fun metod1() {
        println("Ahanda")
    }

    override fun metod2(): String {
        return "Interface çalışması"
    }
}