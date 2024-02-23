package com.hakanbaysal20.contactsappretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        holder.showDetailButton.setOnClickListener {
            val popup = PopupMenu(context,holder.showDetailButton)
            popup.menuInflater.inflate(R.menu.person_detail_menu,popup.menu)
            popup.show()
            popup.setOnMenuItemClickListener {item ->
                when(item.itemId){
                    R.id.delete ->{
                        deletePerson(person.personId)
                        true
                    }
                    R.id.update ->{
                        showAlert(person)
                        true
                    }
                    else -> false
                }
            }
        }
    }
    fun showAlert(person:Person) {
        val layout = LayoutInflater.from(context).inflate(R.layout.edit_text,null)
        val editTextName = layout.findViewById(R.id.editTextPersonName) as EditText
        val editTextNo = layout.findViewById(R.id.editTextPersonNo) as EditText
        editTextName.setText(person.personName)
        editTextNo.setText(person.personNo)
        val addAlert = AlertDialog.Builder(context)
        addAlert.setTitle("Update person")
        addAlert.setView(layout)
        addAlert.setPositiveButton("Update",{dialogInterface,i->
            val personName = editTextName.text.toString().trim()
            val personNo = editTextNo.text.toString().trim()
            updatePerson(Person(person.personId,personName,personNo))
        })
        addAlert.setNegativeButton("Cancel",{dialogInterface,i->
        })
        addAlert.create().show()

    }
    fun updatePerson(person:Person) {
        val contactIDF = ApiUtils.getContactDaoInterface()
        contactIDF.updatePerson(person.personId,person.personName,person.personNo)
            .enqueue(object : Callback<CRUDResponse>{
                override fun onResponse(
                    call: Call<CRUDResponse>?,
                    response: Response<CRUDResponse>
                ) {
                    Toast.makeText(context,"${response.body().message}",Toast.LENGTH_SHORT).show()

                }

                override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {

                }
            })
    }
    fun deletePerson(personId:Int) {
        val contactIDF = ApiUtils.getContactDaoInterface()
        contactIDF.deletePerson(personId).enqueue(object : Callback<CRUDResponse>{
            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>) {
                Toast.makeText(context,response.body().message,Toast.LENGTH_SHORT).show()
            }
        })

    }
}