package com.utad.infopractices

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val imageView = view.findViewById<ImageView>(R.id.loginimage)
        val loginBtn = view.findViewById<Button>(R.id.loginBtn)
        val mailTxt = view.findViewById<EditText>(R.id.mailTxt)
        val pwdTxt = view.findViewById<EditText>(R.id.pwdTxt)
        val txtError = view.findViewById<TextView>(R.id.txtError)

        val email = arguments?.getString("email")
        if (email != null) {
            mailTxt.setText(email)
        }

        imageView.setOnClickListener {
            mailTxt.setText("prueba@example.com")
            pwdTxt.setText("password")
        }

        loginBtn.setOnClickListener {
            if(mailTxt.text.toString().isEmpty()){
                txtError.text = "Mail is required"
                return@setOnClickListener
            }
            if(pwdTxt.text.toString().isEmpty()){
                txtError.text = "Password is required"
                return@setOnClickListener
            }
            if(!android.util.Patterns.EMAIL_ADDRESS.matcher(mailTxt.text.toString()).matches()){
                txtError.text = "The mail is invalid"
                return@setOnClickListener
            }

            val email = mailTxt.text.toString()
            val password = pwdTxt.text.toString()

            // Realizar solicitud de consulta a la base de datos
            val url = "http://10.1.200.249/infopractices/consultar.php?Email=$email&Password=$password"
            val queue = Volley.newRequestQueue(context)
            val request = JsonObjectRequest(
                Request.Method.GET, url, null,
                Response.Listener { response ->
                    Log.d("Response", response.toString())

                    // Verificar si la respuesta indica que el inicio de sesión fue exitoso
                    if (response.getString("status") == "success") {
                        findNavController().navigate(R.id.action_loginFragment_to_practicesFragment)
                    } else {
                        txtError.text = "Incorrect email or password"
                    }
                },
                Response.ErrorListener { error ->
                    Log.d("Error", error.toString())
                }
            )
            queue.add(request)
        }
        return view
    }

}