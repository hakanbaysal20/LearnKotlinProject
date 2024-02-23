package com.hakanbaysal20.contactsappretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakanbaysal20.contactsappretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var contactList:List<Person>
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
        setSupportActionBar(binding.homeToolbar)
    }
    fun showAlert() {
        val layout = LayoutInflater.from(this).inflate(R.layout.edit_text,null)
        val editTextName = layout.findViewById(R.id.editTextPersonName) as EditText
        val editTextNo = layout.findViewById(R.id.editTextPersonNo) as EditText
        val addAlert = AlertDialog.Builder(this)
        addAlert.setTitle("Add person")
        addAlert.setView(layout)
        addAlert.setPositiveButton("Add",{dialogInterface,i->
            val personName = editTextName.text.toString().trim()
            val personNo = editTextNo.text.toString().trim()
            addPerson(personName,personNo)
        })
        addAlert.setNegativeButton("Cancel",{dialogInterface,i->
        })
        addAlert.create().show()

    }
    fun addPerson(personName:String,personNo:String) {
        val contactsIDF = ApiUtils.getContactDaoInterface()
        contactsIDF.addPerson(personName,personNo).enqueue(object : Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>) {
                Toast.makeText(this@MainActivity,"$personName rehbere eklendi",Toast.LENGTH_SHORT).show()
                Log.e("message",response.body().message)
            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {

            }
        })
    }

    fun getContacts() {
        contactList = ArrayList()
        val contactsIDF = ApiUtils.getContactDaoInterface()
        contactsIDF.getContacts().enqueue(object : Callback<PersonResponse>{
            override fun onResponse(
                call: Call<PersonResponse>,
                response: Response<PersonResponse>
            ) {
                val responseList = response.body().contactsList
                contactList = responseList
                adapter = ContactsCardViewAdapter(this@MainActivity,contactList)
                binding.contactsRV.adapter = adapter
            }

            override fun onFailure(call: Call<PersonResponse>?, t: Throwable?) {

            }
        })
    }
    fun searchPerson(personName:String) {
        contactList = ArrayList()
        val contactsIDF = ApiUtils.getContactDaoInterface()
        contactsIDF.searchContacts(personName).enqueue(object : Callback<PersonResponse>{
            override fun onResponse(
                call: Call<PersonResponse>?,
                response: Response<PersonResponse>
            ) {
                contactList = response.body().contactsList
                adapter = ContactsCardViewAdapter(this@MainActivity,contactList)
                binding.contactsRV.adapter = adapter
            }

            override fun onFailure(call: Call<PersonResponse>?, t: Throwable?) {

            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_search_menu,menu)
        val item = menu?.findItem(R.id.search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onQueryTextSubmit(query: String): Boolean {
        searchPerson(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        searchPerson(newText)
        return true
    }
}