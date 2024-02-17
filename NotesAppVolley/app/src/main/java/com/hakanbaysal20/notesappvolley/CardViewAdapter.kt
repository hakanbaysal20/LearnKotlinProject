package com.hakanbaysal20.notesappvolley

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CardViewAdapter(private val mContext:Context,private val noteList:List<Note>)
    :RecyclerView.Adapter<CardViewAdapter.CardViewLayoutHolder>(){

    inner class CardViewLayoutHolder(view:View):ViewHolder(view){
        val lessonName:TextView
        val midterm:TextView
        val final:TextView

        init {
            lessonName = view.findViewById(R.id.textLesson)
            midterm = view.findViewById(R.id.textMidterm)
            final = view.findViewById(R.id.textFinal)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewLayoutHolder {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.card_view,parent,false)
        return CardViewLayoutHolder(layout)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: CardViewLayoutHolder, position: Int) {
        val note = noteList.get(position)
        holder.lessonName.text = note.lessonName
        holder.final.text = note.final.toString()
        holder.midterm.text = note.midterm.toString()

    }
}