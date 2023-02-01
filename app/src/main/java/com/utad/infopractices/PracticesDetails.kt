package com.utad.infopractices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.utad.infopractices.databinding.FragmentPracticesDetailsBinding
import org.w3c.dom.Text

class PracticesDetails : Fragment() {

    private lateinit var cardData: Practices
    private lateinit var binding: FragmentPracticesDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_practices_details, container, false)
        cardData = requireArguments().getParcelable("pratices")!!
        val detalle = view.findViewById<TextView>(R.id.empresaDetail)

        detalle.text = cardData.Company

        return view
    }

    companion object {
        fun newInstance(pratices: Practices) = PracticesDetails().apply {
            arguments = Bundle().apply {
                putParcelable("pratices", pratices)
            }
        }
    }


}