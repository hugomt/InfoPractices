package com.utad.infopractices

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.utad.infopractices.databinding.FragmentRegisterBinding

class registerFragment : Fragment() {

    private var _binding: FragmentRegisterBinding?  = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txt_Email_R = binding.editTextConfirmMail
        val txt_Pass_R = binding.editTextPwdRegister
        val txt_Emailc_R = binding.editTextConfirmMail
        val txt_Passc_R = binding.editTextPwdConfirm
        val aviso_R = binding.txtAvisoR
        binding.registerBtn.setOnClickListener {
            val email_text_R = txt_Email_R.text.toString()
            val email_pass_R = txt_Pass_R.text.toString()
            val email_textc_R = txt_Emailc_R.text.toString()
            val email_passc_R = txt_Passc_R.text.toString()

            if (email_text_R.isEmpty() || email_pass_R.isEmpty() || email_textc_R.isEmpty() || email_passc_R.isEmpty()) {
                aviso_R.text = "Por favor rellene todos los campos"
            } else {
                if (email_text_R != email_textc_R || email_pass_R != email_passc_R) {
                    aviso_R.text = "Los campos no conciden"
                } else {
                    guardar()
                }
            }
        }
    }
    override  fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun guardar(){
        val iRegister = Intent(cosas.context, LoginFragment::class.java)
        iRegister.putExtra("Email", binding.editTextMailRegister.text.toString())
        iRegister.putExtra("Password", binding.editTextPwdRegister.text.toString())
        iRegister.putExtra("Email Confirm", binding.editTextConfirmMail.text.toString())
        iRegister.putExtra("Password Confirm", binding.editTextPwdConfirm.text.toString())
        startActivity(iRegister)
        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
    }

}