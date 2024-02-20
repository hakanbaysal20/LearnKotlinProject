package com.hakanbaysal20.notesappretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.hakanbaysal20.notesappretrofit.databinding.ActivityEditLessonBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditLessonActivity : AppCompatActivity() {
    private lateinit var binding:ActivityEditLessonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var note = intent.getSerializableExtra("note") as Note
        binding.editFinalText.setText(note.finalNote)
        binding.editLessonName.setText(note.lessonName)
        binding.editMidtermText.setText(note.midtermNote)
        setSupportActionBar(binding.editToolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_note_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.delete ->{
                deleteNote()
                true
            }
            R.id.update ->{
                updateNote()
                true
            }
            else -> onOptionsItemSelected(item)
        }
    }
    fun deleteNote() {
        var note = intent.getSerializableExtra("note") as Note
        val notefdi = ApiUtils.getNoteDAOInterface()
        notefdi.deleteNotes(note.noteId).enqueue(object : Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {
                Toast.makeText(applicationContext,"${note.lessonName} başarıyla silindi",Toast.LENGTH_SHORT).show()
                finish()
                startActivity(Intent(this@EditLessonActivity,MainActivity::class.java))
            }
            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {

            }
        })
    }
    fun updateNote() {
         var note = intent.getSerializableExtra("note") as Note
        val notefdi = ApiUtils.getNoteDAOInterface()
        notefdi.updateNotes(
            note.noteId.toString(),
            binding.editLessonName.text.toString().trim(),
            binding.editMidtermText.text.toString().trim(),
            binding.editFinalText.text.toString().trim())
            .enqueue(object : Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {
                Toast.makeText(applicationContext,"${note.lessonName} başarıyla güncellendi",Toast.LENGTH_SHORT).show()
                finish()
                startActivity(Intent(this@EditLessonActivity,MainActivity::class.java))

            }
            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {

            }
        })
    }
}