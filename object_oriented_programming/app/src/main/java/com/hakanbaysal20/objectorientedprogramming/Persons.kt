package com.hakanbaysal20.objectorientedprogramming

class Persons(var ad:String ,var yas:Int) {
// bu sınıftan bir nesne oluşturulduğunda init çalışır (önceliklidir)
    init {
        println("Person object created")
    }
}