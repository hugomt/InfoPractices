package com.utad.infopractices

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class registerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        val mailTxt = view.findViewById<TextView>(R.id.mailTxt)
        val mailConfirmTxt = view.findViewById<TextView>(R.id.mailConfirmTxt)
        val pwdTxt = view.findViewById<EditText>(R.id.pwdTxt)
        val pwdConfirmTxt = view.findViewById<EditText>(R.id.pwdConfirmTxt)
        val registerBtn = view.findViewById<Button>(R.id.registerBtn)
        val txtError = view.findViewById<TextView>(R.id.txtError)

        registerBtn.setOnClickListener {
                if(mailTxt.text.toString().isEmpty()){
                    txtError.text = "Mail is required"
                    return@setOnClickListener
                }
                if(mailConfirmTxt.text.toString().isEmpty()){
                    txtError.text = "Email confirmation is required"
                    return@setOnClickListener
                }
                if(pwdTxt.text.toString().isEmpty()){
                    txtError.text = "Mail is required"
                    return@setOnClickListener
                }
                if(pwdConfirmTxt.text.toString().isEmpty()){
                    txtError.text = "Password confirmation is required"
                    return@setOnClickListener
                }
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(mailTxt.text.toString()).matches()){
                    txtError.text = "The mail is invalid"
                    return@setOnClickListener
                }
                if(mailTxt.text.toString() != mailConfirmTxt.text.toString()){
                    txtError.text = "Mails do not match"
                    return@setOnClickListener
                }
                if(pwdTxt.text.toString().length < 6){
                    txtError.text = "The password must be at least 6 characters long"
                    return@setOnClickListener
                }
                if(pwdTxt.text.toString() != pwdConfirmTxt.text.toString()){
                    txtError.text = "Passwords do not match"
                    return@setOnClickListener
                }
            val email = mailTxt.text.toString()
            val bundle = Bundle()
            bundle.putString("email", email)
            val anotherFragment = LoginFragment()
            anotherFragment.arguments = bundle
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment, bundle)
        }
        return view
    }


}