package com.utad.infopractices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val loginBtn = view.findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_practicesFragment)
        }
        return view
    }


}