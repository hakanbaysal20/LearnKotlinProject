package com.hakanbaysal20.contactsappretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsCardViewAdapter(private val context:Context,private val contactList:List<Person>)
    :RecyclerView.Adapter<ContactsCardViewAdapter.CardViewHolder>(){

    inner class CardViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textPersonName:TextView
        val textPersonNo:TextView
        val showDetailButton:ImageView

        init {
            textPersonName = view.findViewById(R.id.textPersonName)
            textPersonNo = view.findViewById(R.id.textPersonNo)
            showDetailButton = view.findViewById(R.id.showDetailButton)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.contacts_card_view,parent,false)
        return CardViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val person = contactList.get(position)
        holder.textPersonName.text = person.personName
        holder.textPersonNo.text = person.personNo
    }
}