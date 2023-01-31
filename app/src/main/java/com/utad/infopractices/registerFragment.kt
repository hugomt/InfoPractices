package com.utad.infopractices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class registerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        val registerBtn = view.findViewById<Button>(R.id.registerBtn)
        registerBtn.setOnClickListener{

            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        return view
    }



}