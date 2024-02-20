package com.hakanbaysal20.notesappvolley

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.text.set
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.hakanbaysal20.notesappvolley.databinding.ActivityEditNoteBinding

class EditNoteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityEditNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val finalNote = intent.getStringExtra("finalNote")
        val midtermNote = intent.getStringExtra("midtermNote")
        Log.e("asd",finalNote.toString())
        setSupportActionBar(binding.editToolbar)
        val lesson = intent.getStringExtra("lessonName")
        binding.finalNote.setText(finalNote)
        binding.midtermNote.setText(midtermNote)
        binding.lesson.setText(lesson)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_notes_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.delete ->{
                val noteId = intent.getStringExtra("noteId")
                if (noteId != null) {
                    deleteNote(noteId)
                    startActivity(Intent(this@EditNoteActivity,MainActivity::class.java))
                    finish()
                }
                true
            }
            R.id.update ->{
               val midtermNote = binding.midtermNote.text.toString()
                val finalNote = binding.finalNote.text.toString()
                val lessonName = binding.lesson.text.toString()
                val noteId = intent.getStringExtra("noteId")
                updateNote(noteId!!,midtermNote,finalNote,lessonName)
               startActivity(Intent(this@EditNoteActivity,MainActivity::class.java))
                finish()
                true
            }
            else -> onOptionsItemSelected(item)
        }
    }
    fun deleteNote(noteId:String) {
        val baseUrl = "http://kasimadalan.pe.hu/notlar/delete_not.php"
        val request = object : StringRequest(
            Request.Method.POST,baseUrl,
            Response.Listener {  },
            Response.ErrorListener {  }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["not_id"] = noteId
                return params
            }
        }
        Volley.newRequestQueue(this).add(request)
    }
    fun updateNote(noteId: String, midterm: String, finalNote:String,lesson:String) {
        val baseUrl = "http://kasimadalan.pe.hu/notlar/update_not.php"
        val request = object : StringRequest(Request.Method.POST,baseUrl,Response.Listener {response ->
        },
            Response.ErrorListener {  }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["not_id"] = noteId
                params["not1"] = midterm
                params["not2"] = finalNote
                params["ders_adi"] = lesson
                return params
            }
        }
        Volley.newRequestQueue(this).add(request)
    }

}