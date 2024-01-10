package com.hakanbaysal20.externalstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hakanbaysal20.externalstorage.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import kotlin.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonOku.setOnClickListener {
            hariciOku()
        }
        binding.buttonSil.setOnClickListener {
            hariciSil()
        }
        binding.buttonYaz.setOnClickListener {
            hariciYaz()
        }
    }
    fun hariciYaz(){
        try {
            val path = applicationContext.getExternalFilesDir(null)?.absolutePath
            val file = File(path,"myFile.txt")
            if (!file.exists()){
                file.createNewFile()
            }
            val  fw = FileWriter(file)
            val printer = BufferedWriter(fw) // yazıcı ile yazıyoruz
            printer.write(binding.editTextText.text.toString())
            // bağlantıyı koparmamız gerek. performansı etkiler
            printer.flush() // yazma işleminde hata olursa kalan yazma işlemini anında yapmaya çalışır ve veri kaybını önlemeye çalışır
            printer.close()
            fw.close()
            binding.editTextText.setText("")

        }catch (e:Exception){
            e.printStackTrace()
        }
    }
    fun hariciSil() {
        val path = applicationContext.getExternalFilesDir(null)?.absolutePath
        val file = File(path,"myFile.txt")
        binding.editTextText.setText("")
        Toast.makeText(applicationContext,"Silindi",Toast.LENGTH_SHORT).show()
        file.delete()
    }
    fun hariciOku() {
        try {
            val path = applicationContext.getExternalFilesDir(null)?.absolutePath
            val file = File(path,"myFile.txt")
            val fr = FileReader(file)
            val reader = BufferedReader(fr)
            val sb = StringBuilder()
            var row:String? = null
            while ({row = reader.readLine();row}() != null){
                sb.append(row+"\n")
            }
            reader.close()
            binding.editTextText.setText(sb.toString())

        }catch (e:Exception){
            e.printStackTrace()
        }

    }

}