package com.hakanbaysal20.externalstorage
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hakanbaysal20.externalstorage.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonOku.setOnClickListener {
          //  hariciOku()
            internalRead()
        }
        binding.buttonSil.setOnClickListener {
          //  hariciSil()
            internalDelete()
        }
        binding.buttonYaz.setOnClickListener {
           // hariciYaz()
            internalWrite()
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
    fun internalWrite() {
        try {
            val fo = openFileOutput("myFile.txt",Context.MODE_PRIVATE) // fo : File output
            val printer = OutputStreamWriter(fo)
            printer.write(binding.editTextText.text.toString())
            printer.close()
            binding.editTextText.setText("")
            fo.close()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
    fun internalRead() {
        try {
            val fi = openFileInput("myFile.txt")
            val isr = InputStreamReader(fi)
            val reader = BufferedReader(isr)
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
    fun internalDelete() {
        val path = filesDir //path
        val file = File(path,"myFile.txt")
        file.delete()
        binding.editTextText.setText("")
    }
}