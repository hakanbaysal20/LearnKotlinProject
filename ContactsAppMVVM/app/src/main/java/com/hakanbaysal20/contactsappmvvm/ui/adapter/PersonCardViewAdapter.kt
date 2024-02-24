package com.hakanbaysal20.contactsappmvvm.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.hakanbaysal20.contactsappmvvm.R
import com.hakanbaysal20.contactsappmvvm.data.entity.Person
import com.hakanbaysal20.contactsappmvvm.databinding.PersonCardViewBinding
import com.hakanbaysal20.contactsappmvvm.ui.fragment.HomeFragmentDirections
import com.hakanbaysal20.contactsappmvvm.ui.viewmodel.HomeViewModel
import com.hakanbaysal20.contactsappmvvm.utils.push

class PersonCardViewAdapter(
    private val context:Context,
    private val personList:List<Person>,
    private val viewModel:HomeViewModel)
    :RecyclerView.Adapter<PersonCardViewAdapter.CardViewHolder>(){
    inner class CardViewHolder(view:PersonCardViewBinding):RecyclerView.ViewHolder(view.root){
        var binding: PersonCardViewBinding

        init {
            this.binding = view

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val layout:PersonCardViewBinding = DataBindingUtil.inflate(layoutInflater,R.layout.person_card_view,parent,false)
        return CardViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val person = personList.get(position)
        val b = holder.binding
        b.personObject = person

        b.cardView.setOnClickListener{
            val push = HomeFragmentDirections.pushPersonDetail(person)
            Navigation.push(it,push)
        }
        b.cardviewDeletePersonButton.setOnClickListener{
            Snackbar.make(it,"${person.personName} rehberden silinsin mi?",Snackbar.LENGTH_SHORT).setAction("Evet",{
                viewModel.deletePerson(person.personId)
            }).show()
        }
    }

}