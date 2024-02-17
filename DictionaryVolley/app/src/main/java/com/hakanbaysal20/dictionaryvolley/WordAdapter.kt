package com.hakanbaysal20.dictionaryvolley

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(private val mContext:Context,private val wordList:List<Word>)
    : RecyclerView.Adapter<WordAdapter.CardViewObjectsHolder>(){

    inner class CardViewObjectsHolder(view:View):RecyclerView.ViewHolder(view){
        var mainWord:TextView
        var translateWord:TextView

        init {
            mainWord = view.findViewById(R.id.mainWord)
            translateWord = view.findViewById(R.id.translateWord)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewObjectsHolder {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.words_activity,parent,false)
        return CardViewObjectsHolder(layout)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onBindViewHolder(holder: CardViewObjectsHolder, position: Int) {
        val words = wordList[position]
        holder.mainWord.text = words.word
        holder.translateWord.text = words.translateWord
    }
}