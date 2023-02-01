package com.utad.infopractices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val loginBtn = view.findViewById<Button>(R.id.loginBtn)
        val registerBtn = view.findViewById<Button>(R.id.registerBtn)
        loginBtn.setOnClickListener{
            findNavController().navigate(R.id.action_FirstFragment_to_loginFragment)
        }
        registerBtn.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_registerFragment)
        }
        return view
    }
}