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
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakanbaysal20.contactsappmvvm.R
import com.hakanbaysal20.contactsappmvvm.data.entity.Person
import com.hakanbaysal20.contactsappmvvm.databinding.FragmentHomeBinding
import com.hakanbaysal20.contactsappmvvm.ui.adapter.PersonCardViewAdapter
import com.hakanbaysal20.contactsappmvvm.ui.viewmodel.AddPersonViewModel
import com.hakanbaysal20.contactsappmvvm.ui.viewmodel.HomeViewModel
import com.hakanbaysal20.contactsappmvvm.utils.push

class HomeFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var viewModel:HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        binding.homeFragment = this
        binding.homeFragmentToolbarTitle = "Home"

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHome) // setSupportActionBarın fragmentta kullanılması için yazılır

        viewModel.personsList.observe(viewLifecycleOwner){
            val adapter = PersonCardViewAdapter(requireContext(),it,viewModel)
            binding.contactsAdapter = adapter
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
    fun clickFabButton(it:View) {
        Navigation.push(it,R.id.pushAddPerson)
    }


    override fun onQueryTextSubmit(p0: String): Boolean {
        viewModel.searchPerson(p0)
        return true
    }

    override fun onQueryTextChange(p0: String): Boolean {
        viewModel.searchPerson(p0)
        return true
    }
    override fun onResume() {// arayüzü güncellemek için kullanırız. home page e dönüldüğünü gösterir. flutterda then propertysi gibi
        super.onResume()
        viewModel.getContacts()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomeViewModel by viewModels()
        viewModel = tempViewModel
    }
}