package com.hakanbaysal20.contactsappvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.hakanbaysal20.contactsappvolley.databinding.ActivityMainBinding
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var contactsList: ArrayList<Person>
    private lateinit var adapter:ContactsCardViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.contactsRV.setHasFixedSize(true)
        binding.contactsRV.layoutManager = LinearLayoutManager(this)
        getContacts()
        binding.fab.setOnClickListener {
            showAlert()
        }
    }
    fun showAlert() {
        val alertLayout = LayoutInflater.from(this).inflate(R.layout.edit_text,null)
        val editTextName = alertLayout.findViewById(R.id.editTextName) as EditText
        val editTextNo = alertLayout.findViewById(R.id.editTextNo) as EditText
        val addAlert = AlertDialog.Builder(this)
        addAlert.setTitle("Add Person")
        addAlert.setView(alertLayout)
        addAlert.setNegativeButton("Cancel"){ dialogInterface, i ->
        }
        addAlert.setPositiveButton("Add"){dialogInterface,i ->
            val personName = editTextName.text.toString().trim()
            val personNo = editTextNo.text.toString().trim()
            addContacts(personName,personNo)
            Toast.makeText(this,"${personName} rehbere eklendi",Toast.LENGTH_SHORT).show()
        }
        addAlert.create().show()
    }
    fun getContacts() {
        contactsList = ArrayList<Person>()
        val baseUrl = "http://kasimadalan.pe.hu/kisiler/tum_kisiler.php"
        val request = StringRequest(Request.Method.GET,baseUrl,Response.Listener { response ->
            try {
                val jsonObject = JSONObject(response)
                val responseList = jsonObject.getJSONArray("kisiler")
                for (i in 0 until responseList.length()){
                    val responsePerson = responseList.getJSONObject(i)
                    val person = Person(responsePerson.getInt("kisi_id"),responsePerson.getString("kisi_ad"),responsePerson.getString("kisi_tel"))
                    contactsList.add(person)
                }
                adapter = ContactsCardViewAdapter(this@MainActivity,contactsList)
                binding.contactsRV.adapter = adapter

            }catch (e:JSONException){
                e.printStackTrace()
            }

        },Response.ErrorListener { error ->
            error.printStackTrace()
        })
        Volley.newRequestQueue(this@MainActivity).add(request)
    }
    fun addContacts(personName:String,personNo:String) {
        val baseUrl = "http://kasimadalan.pe.hu/kisiler/insert_kisiler.php"
        val request = object : StringRequest(Method.POST,baseUrl,Response.Listener {  },Response.ErrorListener {  }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["kisi_ad"] = personName
                params["kisi_tel"] = personNo
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(request)
    }
}