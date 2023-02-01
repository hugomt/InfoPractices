package com.utad.infopractices

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val loginBtn = view.findViewById<Button>(R.id.loginBtn)
        val mailTxt = view.findViewById<EditText>(R.id.mailTxt)
        val pwdTxt = view.findViewById<EditText>(R.id.pwdTxt)
        val txtError = view.findViewById<TextView>(R.id.txtError)

        val email = arguments?.getString("email")
        if (email != null) {
            mailTxt.setText(email)
        }


        loginBtn.setOnClickListener {
            if(mailTxt.text.toString().isEmpty()){
                txtError.text = "El correo es requerido"
                return@setOnClickListener
            }
            if(pwdTxt.text.toString().isEmpty()){
                txtError.text = "La contraseña es requerida"
                return@setOnClickListener
            }
            findNavController().navigate(R.id.action_loginFragment_to_practicesFragment)
        }
        return view
    }
}