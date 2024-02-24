package com.hakanbaysal20.contactsappmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hakanbaysal20.contactsappmvvm.databinding.FragmentAddPersonBinding

class AddPersonFragment : Fragment() {
    private lateinit var binding: FragmentAddPersonBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPersonBinding.inflate(inflater,container,false)

        binding.addPersonButton.setOnClickListener{
            val personName = binding.textInputPersonName.text.toString()
            val personNumber = binding.textInputPersonNumber.text.toString()
            addPerson(personName,personNumber)
        }
        return binding.root
    }
    fun addPerson(personName:String,personNumber:String) {
        Log.e("Person Name",personName)
        Log.e("Person Number",personNumber)
        Toast.makeText(requireContext(),"${personName} - ${personNumber} rehbere eklendi",Toast.LENGTH_SHORT).show()
    }

}