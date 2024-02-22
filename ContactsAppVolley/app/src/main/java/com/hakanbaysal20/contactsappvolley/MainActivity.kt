package com.hakanbaysal20.contactsappvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
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
}