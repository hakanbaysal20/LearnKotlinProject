package com.hakanbaysal20.collections.thread

class IkinciThread:Runnable { // runnable ile ekledik

    override fun run() {
        for (i in 200..299){
            println("İkinci thread : $i")
            Thread.sleep(100)
        }
    }
}