package com.hakanbaysal20.notesappvolley

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.hakanbaysal20.notesappvolley.databinding.ActivityAddNotesBinding
import com.hakanbaysal20.notesappvolley.databinding.ActivityMainBinding
import org.json.JSONException

class AddNotesActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddNotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addLessonButton.setOnClickListener {
            addNotes()
        }
    }

    fun addNotes() {
        val baseUrl = "http://kasimadalan.pe.hu/notlar/insert_not.php"
        val request = object : StringRequest(Request.Method.POST,baseUrl,Response.Listener { response ->
            try {
                startActivity(Intent(this@AddNotesActivity,MainActivity::class.java))
                finish()
                Toast.makeText(this,"Ders başarıyla eklendi",Toast.LENGTH_SHORT).show()

            }catch (e:JSONException){
                e.printStackTrace()
            }
        },Response.ErrorListener {error ->
        error.printStackTrace()
        }){
            override fun getParams(): MutableMap<String, String>? {
                val lessonName = binding.addLessonName.text
                val midterm = binding.addMidtermText.text
                val final = binding.addFinalText.text
                val params = HashMap<String,String>()
                params["ders_adi"] = lessonName.toString()
                params["not1"] = midterm.toString()
                params["not2"] = final.toString()
                return params
            }
        }
        Volley.newRequestQueue(this).add(request)
    }

}