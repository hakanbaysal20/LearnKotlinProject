package com.hakanbaysal20.contactsappmvvm.ui.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.hakanbaysal20.contactsappmvvm.R
import com.hakanbaysal20.contactsappmvvm.data.entity.Person

class PersonCardViewAdapter(private val context:Context,private val personList:List<Person>) {

    inner class CardViewHolder(view:View):RecyclerView.ViewHolder(view){
        val cardviewPersonName:TextView
        val cardviewPersonNumber:TextView
        val cardviewDeletePerson:ImageView
        val cardView:CardView

        init {
            cardView = view.findViewById(R.id.cardView)
            cardviewDeletePerson = view.findViewById(R.id.cardviewDeletePersonButton)
            cardviewPersonName = view.findViewById(R.id.cardviewPersonName)
            cardviewPersonNumber = view.findViewById(R.id.cardviewPersonNumber)
        }
    }
}