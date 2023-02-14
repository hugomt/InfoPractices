package com.utad.infopractices

import android.os.Bundle
import android.text.InputFilter
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout


class applyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_apply, container, false)

        val inputName = view.findViewById<TextInputLayout>(R.id.inputName)
        val editTextName = inputName.editText
        val inputSurname = view.findViewById<TextInputLayout>(R.id.inputSurname)
        val editTextSurname = inputSurname.editText
        val inputPhone = view.findViewById<TextInputLayout>(R.id.inputPhone)
        val editTextPhone = inputPhone.editText
        val radioButtonGroup = view.findViewById<RadioGroup>(R.id.radioButtonGroup)
        val spinnerEducationLevel = view.findViewById<Spinner>(R.id.spinnerEducationLevel)
        val txtError = view.findViewById<TextView>(R.id.txtError)
        val sumbitButton = view.findViewById<Button>(R.id.sumbitButton)

        sumbitButton.setOnClickListener(){
            if (editTextName != null) {
                if(editTextName.text.toString().isEmpty()){
                    txtError.text = "Name is required"
                    return@setOnClickListener
                }
            }
            if (editTextSurname != null) {
                if(editTextSurname.text.toString().isEmpty()){
                    txtError.text = "Surname is required"
                    return@setOnClickListener
                }
            }
            if (editTextPhone != null) {
                if(editTextPhone.text.toString().isEmpty()){
                    txtError.text = "Phone is required"
                    return@setOnClickListener
                }
            }
            if (radioButtonGroup.checkedRadioButtonId == -1) {
                txtError.text = "Select one of the radio buttons"
                return@setOnClickListener
            }
            if (spinnerEducationLevel.selectedItemPosition == 0) {
                txtError.text = "Education level is required"
                return@setOnClickListener
            }
            txtError.text = ""
            findNavController().popBackStack()
            Toast.makeText(context, "Saved application", Toast.LENGTH_SHORT).show()
        }
        return view
    }
}