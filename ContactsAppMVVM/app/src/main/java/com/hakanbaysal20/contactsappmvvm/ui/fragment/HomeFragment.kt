package com.hakanbaysal20.contactsappmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.hakanbaysal20.contactsappmvvm.R
import com.hakanbaysal20.contactsappmvvm.databinding.FragmentHomeBinding

class HomeFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.toolbarHome.setTitle("Home")
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHome)
        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.pushAddPerson)
        }
        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.person_search_menu,menu)

                val item = menu.findItem(R.id.searchPerson)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)
        return binding.root
    }


    fun searchPerson(word:String) {

    }

    override fun onQueryTextSubmit(p0: String): Boolean {
        searchPerson(p0)
        return true
    }

    override fun onQueryTextChange(p0: String): Boolean {
        searchPerson(p0)
        return true
    }


}