package com.hakanbaysal20.contactsappvolley

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
import com.android.volley.Request
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar

class ContactsCardViewAdapter(private val context:Context,private val contactsList:ArrayList<Person>)
    :RecyclerView.Adapter<ContactsCardViewAdapter.CardViewHolder>(){

    inner class CardViewHolder(view:View):RecyclerView.ViewHolder(view){
        val showDetailButton:ImageView
        val personName:TextView
        val personNo:TextView
        init {
            showDetailButton = view.findViewById(R.id.showDetailButton)
            personName = view.findViewById(R.id.textPersonName)
            personNo = view.findViewById(R.id.textPersonNo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.person_card_view,parent,false)
        return CardViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val person = contactsList.get(position)
        holder.showDetailButton.setOnClickListener {
            val popup = PopupMenu(context,holder.showDetailButton)
            popup.menuInflater.inflate(R.menu.show_detail_button,popup.menu)
            popup.show()
            popup.setOnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.delete -> {
                        Snackbar.make(holder.showDetailButton,"${person.personName} kişisi silinsin mi? ",Snackbar.LENGTH_SHORT)
                            .setAction("Evet",{
                                deletePerson(person.personId)
                                notifyDataSetChanged()
                            }).show()
                        true
                    }
                    R.id.update -> {
                        showAlert(person)
                        true
                    }
                    else -> false
                }
            }
        }
        holder.personName.text = person.personName
        holder.personNo.text = person.personNo

    }
    fun showAlert(person: Person) {
        val alertLayout = LayoutInflater.from(context).inflate(R.layout.edit_text,null)
        val editTextName = alertLayout.findViewById(R.id.editTextName) as EditText
        val editTextNo = alertLayout.findViewById(R.id.editTextNo) as EditText
        editTextName.setText(person.personName)
        editTextNo.setText(person.personNo)
        val addAlert = AlertDialog.Builder(context)
        addAlert.setTitle("Update Person")
        addAlert.setView(alertLayout)
        addAlert.setNegativeButton("Cancel"){ dialogInterface, i ->
        }
        addAlert.setPositiveButton("Update"){dialogInterface,i ->
            val newPersonName = editTextName.text.toString().trim()
            val newPersonNo = editTextNo.text.toString().trim()
            updatePerson(Person(person.personId,newPersonName,newPersonNo))
            notifyDataSetChanged()
        }
        addAlert.create().show()
    }
    fun updatePerson(person: Person) {
        val baseUrl = "http://kasimadalan.pe.hu/kisiler/update_kisiler.php"
        val request = object : StringRequest(Request.Method.POST,baseUrl,Response.Listener {
           Toast.makeText(context,person.personName,Toast.LENGTH_SHORT).show()
        },Response.ErrorListener {  }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["kisi_id"] = person.personId.toString()
                params["kisi_ad"] = person.personName
                params["kisi_tel"] = person.personNo
                return params
            }
        }
        Volley.newRequestQueue(context).add(request)
    }
    fun deletePerson(personId:Int) {
        val baseUrl = "http://kasimadalan.pe.hu/kisiler/delete_kisiler.php"
        val request = object : StringRequest(Request.Method.POST,baseUrl,Response.Listener {
          Toast.makeText(context,"Silme işlemi başarılı",Toast.LENGTH_SHORT).show()
        },Response.ErrorListener {  }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["kisi_id"] = personId.toString()
                return params
            }
        }
        Volley.newRequestQueue(context).add(request)
    }


}