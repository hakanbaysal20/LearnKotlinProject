package com.hakanbaysal20.collections.thread

class BirinciThread:Thread() {

    override fun run() {
        super.run()
        for (i in 100..199){
            println("Birinci thread : $i")
            Thread.sleep(100) // bekletme
        }
    }
}