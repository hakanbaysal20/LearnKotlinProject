package com.hakanbaysal20.objectorientedprogramming.package2

import com.hakanbaysal20.objectorientedprogramming.package1.A

class B:A() {

    fun function() {
     /*   val object1 = A()
        println(object1.defaultVariable)
        println(object1.publicVariable)
        println(object1.privateVariable) // erişim yok sadece sınıf içerisinde erişilebilir
        println(object1.internalVariable)
        println(object1.protectedVariable)// erişim yok sınıf içerisinden veya A sınıfından türemesi gerekir. (Inheritance)
*/
        println(defaultVariable)
        println(publicVariable)

        println(internalVariable)
        println(protectedVariable) // B A classından türedi ve erişim var.
    }
}