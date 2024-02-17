package com.hakanbaysal20.dictionaryretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardViewAdapter(private var mContext:Context,private var wordList:List<Word>)
    :RecyclerView.Adapter<CardViewAdapter.CardViewHolder>(){


    inner class CardViewHolder(view:View):RecyclerView.ViewHolder(view){
        var mainWord:TextView
        var translateWord:TextView

        init {
            mainWord = view.findViewById(R.id.mainWord)
            translateWord = view.findViewById(R.id.translateWord)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.card_view,parent,false)
        return CardViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val word = wordList.get(position)
        holder.mainWord.text = word.mainWord
        holder.translateWord.text = word.translateWord
    }
}