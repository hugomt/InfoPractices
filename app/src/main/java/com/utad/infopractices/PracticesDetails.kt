package com.utad.infopractices

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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
        val buttonFollow = view.findViewById<Button>(R.id.buttonFollow)
        val home = view.findViewById<TextView>(R.id.homeDetail)
        val salary = view.findViewById<TextView>(R.id.salaryDetail)
        val paper = view.findViewById<TextView>(R.id.contratoDetail)
        val ubication = view.findViewById<TextView>(R.id.locationDetail)
        val applyButton = view.findViewById<Button>(R.id.applyButton)

        arrowImagen.setOnClickListener {
            val practicesFragment = practicesFragment.newInstance()
            val activity = it.context as AppCompatActivity
            val transaction =  activity.supportFragmentManager?.beginTransaction()
            transaction?.add(R.id.practicesDetails, practicesFragment)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        buttonFollow.setOnClickListener {
            if(buttonFollow.text == "+ Follow"){
                buttonFollow.text = "- Unfollow"
                buttonFollow.setTextColor(Color.WHITE)
                buttonFollow.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.blue))
            } else {
                buttonFollow.text = "+ Follow"
                buttonFollow.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue))
                buttonFollow.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
        }

        applyButton.setOnClickListener {
            val activity = it.context as AppCompatActivity
            val transaction =  activity.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.practicesDetails, applyFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        descripcion.text = cardData.description
        imagen.setImageResource(cardData.Image)
        home.text = cardData.home
        ubication.text = cardData.locationText
        salary.text = cardData.salary
        paper.text = cardData.paper


        return view
    }

    companion object {
        fun newInstance(practices: Practices) = PracticesDetails().apply {
            arguments = Bundle().apply {
                putParcelable("pratices", practices)
            }
        }
    }


}