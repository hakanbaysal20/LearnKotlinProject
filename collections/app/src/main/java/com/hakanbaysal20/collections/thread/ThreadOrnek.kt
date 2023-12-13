package com.hakanbaysal20.collections.thread

fun main() {

    val birinciThread = BirinciThread()
    birinciThread.start() //  birinciThread.run() bunu yaparsak thread ile çalışmaz. kalıtımdan farklı kullanılır
    val ikinciThread = Thread(IkinciThread())
    ikinciThread.start()

    for (i in 900..999){
        println("Main thread: $i")
        Thread.sleep(100)
    }

}