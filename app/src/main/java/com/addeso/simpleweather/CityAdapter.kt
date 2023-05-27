package com.addeso.simpleweather

import android.os.Bundle
import android.provider.Settings.Global.putString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class CityAdapter(private val cities: List<City>) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cities[position]
        holder.nameTextView.text = city.name
        holder.countryTextView.text = city.country
        holder.itemView.setOnClickListener {
            val actionId = R.id.action_cityFragment_to_weatherFragment
            val bundle = Bundle().apply {
                putString("cityId", city.id.toString())
            }
            it.findNavController().navigate(actionId, bundle)
        }



    }

    override fun getItemCount() = cities.size

    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.city_name)
        val countryTextView: TextView = itemView.findViewById(R.id.city_country)
    }
}
