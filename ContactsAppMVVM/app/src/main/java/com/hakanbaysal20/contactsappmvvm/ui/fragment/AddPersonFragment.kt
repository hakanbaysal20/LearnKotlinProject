package com.hakanbaysal20.contactsappmvvm.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.hakanbaysal20.contactsappmvvm.R
import com.hakanbaysal20.contactsappmvvm.databinding.FragmentAddPersonBinding
import com.hakanbaysal20.contactsappmvvm.ui.viewmodel.AddPersonViewModel


class AddPersonFragment : Fragment() {
    private lateinit var binding: FragmentAddPersonBinding
    private lateinit var viewModel: AddPersonViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_person,container,false)
        binding.addPersonFragment = this
        binding.addPersonToolbarTitle = "Add Person"
        binding.toolbarAddPerson.setSubtitle("")
        return binding.root
    }
    fun clickAddPersonButton(personName:String,personNumber:String) {
        viewModel.addPerson(personName,personNumber)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AddPersonViewModel by viewModels()
        viewModel = tempViewModel
    }

}