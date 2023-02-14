package com.utad.infopractices

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.utad.infopractices.MainActivity
import org.json.JSONObject

class registerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        val imageView = view.findViewById<ImageView>(R.id.loginimage)
        val mailTxt = view.findViewById<TextView>(R.id.mailTxt)
        val mailConfirmTxt = view.findViewById<TextView>(R.id.mailConfirmTxt)
        val pwdTxt = view.findViewById<EditText>(R.id.pwdTxt)
        val pwdConfirmTxt = view.findViewById<EditText>(R.id.pwdConfirmTxt)
        val registerBtn = view.findViewById<Button>(R.id.registerBtn)
        val txtError = view.findViewById<TextView>(R.id.txtError)

        imageView.setOnClickListener {
            mailTxt.setText("prueba@example.com")
            mailConfirmTxt.setText("prueba@example.com")
            pwdTxt.setText("password")
            pwdConfirmTxt.setText("password")
        }

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
                    txtError.text = "Password is required"
                    return@setOnClickListener
                }
                if(pwdConfirmTxt.text.toString().isEmpty()){
                    txtError.text = "Password confirmation is required"
                    return@setOnClickListener
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(mailTxt.text.toString()).matches()){
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
            insertData(mailTxt.text.toString(), pwdTxt.text.toString())
        }
        return view
    }
    private fun insertData(Email: String, Password: String) {
        val url = "http://10.1.200.249/infopractices/insertar.php"
        val queue = Volley.newRequestQueue(context)
        val data = JSONObject()
        data.put("Email", Email)
        data.put("Password", Password)
        val request = JsonObjectRequest(
            Request.Method.POST, url, data,
            Response.Listener { response ->
                Log.d("Response", response.toString())
            },
            Response.ErrorListener { error ->
                Log.d("Error", error.toString())
            }
        )
        queue.add(request)
    }
}
