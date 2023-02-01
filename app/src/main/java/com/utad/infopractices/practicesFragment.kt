package com.utad.infopractices

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class practicesFragment : Fragment() {

    private lateinit var adapter: PracticesAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var practicesArrayList : ArrayList<Practices>

    lateinit var imageId : Array<Int>
    lateinit var companyName : Array<String>
    lateinit var time : Array<String>
    lateinit var locationImage : Array<Int>
    lateinit var locationTxt : Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_practices, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.RecyclerViewList)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = PracticesAdapter(practicesArrayList)
        recyclerView.adapter = adapter
    }



    private fun dataInitialize() {

        practicesArrayList = arrayListOf<Practices>()

        imageId = arrayOf(
            R.drawable.neoris,
            R.drawable.accenture,
            R.drawable.deloitte,
        )

        companyName = arrayOf(
            getString(R.string.practices_a),
            getString(R.string.practices_b),
            getString(R.string.practices_c)
        )

        time = arrayOf(
            getString(R.string.time_a),
            getString(R.string.time_b),
            getString(R.string.time_c)
        )

        locationImage = arrayOf(
            R.drawable.locationlogo,
            R.drawable.locationlogo,
            R.drawable.locationlogo
        )

        locationTxt = arrayOf(
            getString(R.string.location_a),
            getString(R.string.location_b),
            getString(R.string.location_c)
        )

        for (i in imageId.indices) {

            val practices = Practices(imageId[i],companyName[i],time[i],locationImage[i],locationTxt[i])
            practicesArrayList.add(practices)
        }


    }
}
