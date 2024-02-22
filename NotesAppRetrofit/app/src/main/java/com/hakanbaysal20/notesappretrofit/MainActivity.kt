package com.hakanbaysal20.notesappretrofit

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakanbaysal20.notesappretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var noteList:List<Note>
    private lateinit var adapter:CardViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rv.setHasFixedSize(true)
        setSupportActionBar(binding.toolbar)
        binding.rv.layoutManager = LinearLayoutManager(this)
        getNotes()
        binding.fab.setOnClickListener {
            startActivity(Intent(this@MainActivity,AddLessonActivity::class.java))
        }
    }
    fun getNotes() {
        noteList = ArrayList<Note>()
        val noteIDF = ApiUtils.getNoteDAOInterface()
        noteIDF.getNotes().enqueue(object : Callback<NoteResponse>{
            override fun onResponse(call: Call<NoteResponse>, response: Response<NoteResponse>) {
               val responseList = response.body().notes
                noteList = responseList
                adapter = CardViewAdapter(this@MainActivity,noteList)
                binding.rv.adapter = adapter
                gpa(noteList)
            }

            override fun onFailure(call: Call<NoteResponse>?, t: Throwable?) {
            }
        })
    }
    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
    fun gpa(noteList:List<Note>) {
        var total = 0
        for (i in 0 until noteList.size){
            val k = noteList[i]
            total += ((k.midtermNote.toInt() + k.finalNote.toInt()) / 2)
        }
        val average = total / noteList.size
       binding.toolbar.setSubtitle(average.toString())
       binding.toolbar.setSubtitleTextColor(Color.WHITE)

    }
}