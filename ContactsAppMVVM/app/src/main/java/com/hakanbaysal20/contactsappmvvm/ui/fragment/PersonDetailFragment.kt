package com.hakanbaysal20.contactsappmvvm.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.hakanbaysal20.contactsappmvvm.data.entity.Person
import com.hakanbaysal20.contactsappmvvm.databinding.FragmentPersonDetailBinding
import com.hakanbaysal20.contactsappmvvm.ui.fragment.PersonDetailFragmentArgs

class PersonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPersonDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonDetailBinding.inflate(inflater,container,false)

        binding.toolbarPersonDetail.setTitle("Person Detail")
        val bundle: PersonDetailFragmentArgs by navArgs()
        val person = bundle.person

        binding.updatePersonName.setText(person.personName)
        binding.updatePersonNumber.setText(person.personNumber)

        binding.updateButton.setOnClickListener{

        }
        return binding.root
    }
    fun updatePerson(person:Person) {
        Toast.makeText(requireContext(),"${person.personId} - ${person.personName} - ${person.personNumber}",Toast.LENGTH_SHORT).show()
    }
}