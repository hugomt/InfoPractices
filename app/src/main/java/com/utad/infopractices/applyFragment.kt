package com.utad.infopractices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class applyFragment : Fragment() {

    private lateinit var cardData: Practices

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_apply, container, false)
        val arrowImage = view.findViewById<ImageView>(R.id.arrowImage)
        val imageView = view.findViewById<ImageView>(R.id.empresaimage)
        cardData = requireArguments().getParcelable("pratices")!!

        imageView.setImageResource(cardData.Image)

        return view
    }

}