package com.utad.infopractices

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

s
class applyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_apply, container, false)

        val arrowImage = view.findViewById<ImageView>(R.id.arrowImage)
        val btn = view.findViewById<Button>(R.id.sumbitButton)

        btn.setOnClickListener(){
            Toast.makeText(context, "Saved application", Toast.LENGTH_SHORT).show()
        }

        return view
    }

}