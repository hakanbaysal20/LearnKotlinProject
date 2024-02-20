package com.hakanbaysal20.notesappretrofit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CardViewAdapter(private val mContext:Context,private val noteList:List<Note>)
    :RecyclerView.Adapter<CardViewAdapter.CardViewHolder>(){

    inner class CardViewHolder(view:View):RecyclerView.ViewHolder(view){
        val lessonName:TextView
        val midtermNote:TextView
        val finalNote:TextView
        val cardview:CardView
    init {
        lessonName = view.findViewById(R.id.lessonName)
        midtermNote = view.findViewById(R.id.midtermNote)
        finalNote = view.findViewById(R.id.finalNote)
        cardview = view.findViewById(R.id.cardview)
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.card_view,parent,false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val note = noteList.get(position)
        holder.lessonName.text = note.lessonName
        holder.finalNote.text = note.finalNote
        holder.midtermNote.text = note.midtermNote
        holder.cardview.setOnClickListener {
            val intent = Intent(mContext,EditLessonActivity::class.java)
            intent.putExtra("note",note)

            mContext.startActivity(intent)
        }
    }

}