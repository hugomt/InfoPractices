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
                    txtError.text = "El correo es requerido"
                    return@setOnClickListener
                }
                if(mailConfirmTxt.text.toString().isEmpty()){
                    txtError.text = "La confirmación de correo es requerida"
                    return@setOnClickListener
                }
                if(pwdTxt.text.toString().isEmpty()){
                    txtError.text = "La contraseña es requerida"
                    return@setOnClickListener
                }
                if(pwdConfirmTxt.text.toString().isEmpty()){
                    txtError.text = "La confirmación de contraseña es requerida"
                    return@setOnClickListener
                }
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(mailTxt.text.toString()).matches()){
                    txtError.text = "El correo no es válido"
                    return@setOnClickListener
                }
                if(mailTxt.text.toString() != mailConfirmTxt.text.toString()){
                    txtError.text = "Los correos no coinciden"
                    return@setOnClickListener
                }
                if(pwdTxt.text.toString().length < 6){
                    txtError.text = "La contraseña debe tener al menos 6 caracteres"
                    return@setOnClickListener
                }
                if(pwdTxt.text.toString() != pwdConfirmTxt.text.toString()){
                    txtError.text = "Las contraseñas no coinciden"
                    return@setOnClickListener
                }
            txtError.setTextColor(Color.GREEN)
            txtError.text = "Usuario registrado correctamente"
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        return view
    }


}