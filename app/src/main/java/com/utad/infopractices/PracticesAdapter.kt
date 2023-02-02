package com.utad.infopractices

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class PracticesAdapter( private val practicesList: ArrayList<Practices>) : RecyclerView.Adapter<PracticesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_practices, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = practicesList[position]
        holder.image.setImageResource(currentItem.Image)
        holder.companyName.text = currentItem.Company
        holder.txtTime.text = currentItem.Time
        holder.locationText.text = currentItem.locationText
        val description = currentItem.description
        val home = currentItem.home
        val salary = currentItem.salary
        val paper = currentItem.paper
        holder.itemView.setOnClickListener {
            val cardData = Practices(currentItem.Image,currentItem.Company, currentItem.Time, currentItem.locationText, description, home,salary,paper)
            val PracticesDetails = PracticesDetails.newInstance(cardData)
            val activity = it.context as AppCompatActivity
            val transaction =  activity.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.practicesFragment, PracticesDetails)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
    }

    override fun getItemCount(): Int {
        return practicesList.size
    }

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.findViewById(R.id.imageView)
        val companyName : TextView = itemView.findViewById(R.id.companyName)
        val txtTime : TextView = itemView.findViewById(R.id.txtTime)
        val locationText : TextView = itemView.findViewById(R.id.txtLocation)


    }



}