package com.hakanbaysal20.ilkproje.context

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentDeneme:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(activity,"Merhaba",Toast.LENGTH_SHORT).show()
        // hangi activity'e bağlıysa onu cağırır
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}