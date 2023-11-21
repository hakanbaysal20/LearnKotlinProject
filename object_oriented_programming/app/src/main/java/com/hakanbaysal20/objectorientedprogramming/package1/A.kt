package com.hakanbaysal20.objectorientedprogramming.package1

open class A {

    var defaultVariable = 1
    public var publicVariable = 2
    private var privateVariable = 3
    internal var internalVariable = 4
    protected var protectedVariable = 5


    fun function1() {
        /*   val object1 = A()
           println(object1.defaultVariable)
           println(object1.publicVariable)
           println(object1.privateVariable) // erişim yok sadece sınıf içerisinde erişilebilir
           println(object1.internalVariable)
           println(object1.protectedVariable)// erişim yok sınıf içerisinden veya A sınıfından türemesi gerekir. (Inheritance)
   */
        println(defaultVariable)
        println(publicVariable)
        println(privateVariable)
        println(internalVariable)
        println(protectedVariable)
    }
}