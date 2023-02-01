package com.utad.infopractices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
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

        val descripcion = view.findViewById<TextView>(R.id.empresaDescription)
        val imagen = view.findViewById<ImageView>(R.id.imageDetail)
        val arrowImagen = view.findViewById<ImageView>(R.id.imageView9)

        arrowImagen.setOnClickListener {
            val practicesFragment = practicesFragment.newInstance()
            val activity = it.context as AppCompatActivity
            val transaction =  activity.supportFragmentManager?.beginTransaction()
            transaction?.add(R.id.practicesDetails, practicesFragment)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        descripcion.text = cardData.description
        imagen.setImageResource(cardData.Image)

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