package com.hakanbaysal20.contactsappmvvm.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.hakanbaysal20.contactsappmvvm.R
import com.hakanbaysal20.contactsappmvvm.data.entity.Person
import com.hakanbaysal20.contactsappmvvm.databinding.FragmentPersonDetailBinding
import com.hakanbaysal20.contactsappmvvm.ui.fragment.PersonDetailFragmentArgs
import com.hakanbaysal20.contactsappmvvm.ui.viewmodel.AddPersonViewModel
import com.hakanbaysal20.contactsappmvvm.ui.viewmodel.PersonDetailViewModel

class PersonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPersonDetailBinding
    private lateinit var viewModel:PersonDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person_detail,container,false)
        binding.updatePersonFragment = this
        binding.updatePersonToolbarTitle = "Person Detail"
        val bundle: PersonDetailFragmentArgs by navArgs()
        val person = bundle.person
        binding.personObject = person

        return binding.root
    }
    fun clickUpdateButton(personId:Int,personName:String,personNo:String) {
        viewModel.updateButton(personId,personName,personNo)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : PersonDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

}