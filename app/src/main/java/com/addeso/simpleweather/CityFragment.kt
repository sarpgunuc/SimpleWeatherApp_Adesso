package com.addeso.simpleweather


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

class CityFragment : Fragment() {
    private lateinit var cityListView: RecyclerView
    private lateinit var cityAdapter: CityAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.city_page, container, false)

        cityListView = view.findViewById(R.id.list_view)
        cityListView.layoutManager = LinearLayoutManager(context)

        val weatherButton: Button = view.findViewById(R.id.weather_button)
        weatherButton.setOnClickListener {
            findNavController().navigate(R.id.action_cityFragment_to_weatherFragment)
        }


        loadCities()

        return view
    }

    private fun loadCities() {
        val cityStream = requireContext().resources.openRawResource(R.raw.city_list)
        val reader = InputStreamReader(cityStream)
        val citiesType = object : TypeToken<List<City>>() {}.type
        val cities: List<City> = Gson().fromJson(reader, citiesType)

        cityAdapter = CityAdapter(cities)
        cityListView.adapter = cityAdapter

    }
}


