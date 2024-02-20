package com.hakanbaysal20.notesappretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.hakanbaysal20.notesappretrofit.databinding.ActivityAddLessonBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddLessonActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddLessonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            addNote()
        }
    }
    fun addNote() {
        val lessonName = binding.addLessonName.text.toString().trim()
        val midtermNote = binding.addMidterm.text.toString().trim()
        val finalNote = binding.addFinal.text.toString().trim()
        val noteIDF = ApiUtils.getNoteDAOInterface()
        noteIDF.addNotes(lessonName,midtermNote,finalNote).enqueue(object : Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {
                Toast.makeText(applicationContext,"$lessonName başarıyla eklendi",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@AddLessonActivity,MainActivity::class.java))
                finish()
            }
            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {

            }
        })
    }

}