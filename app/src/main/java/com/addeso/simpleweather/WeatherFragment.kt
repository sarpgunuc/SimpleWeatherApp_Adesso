package com.addeso.simpleweather

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.addeso.simpleweatherapp.Activites.WeatherData
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class WeatherFragment : Fragment(R.layout.weather_page) {

    private lateinit var weatherService: WeatherService


    private lateinit var tvCityName: TextView
    private lateinit var tvCurrentTemp: TextView
    private lateinit var tvFeelsLike: TextView
    private lateinit var tvHighestTemp: TextView
    private lateinit var tvLowestTemp: TextView
    private lateinit var tvWindSpeed: TextView
    private lateinit var tvWindDeg: TextView
    private lateinit var tvLon: TextView
    private lateinit var tvLat: TextView
    private lateinit var tvSeaLevel: TextView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        tvCityName = view.findViewById(R.id.tv_city_name)
        tvCurrentTemp = view.findViewById(R.id.tv_current_temp)
        tvFeelsLike = view.findViewById(R.id.tv_feels_like)
        tvHighestTemp = view.findViewById(R.id.tv_highest_temp)
        tvLowestTemp = view.findViewById(R.id.tv_lowest_temp)
        tvWindSpeed = view.findViewById(R.id.tv_wind_speed)
        tvWindDeg = view.findViewById(R.id.tv_wind_deg)
        tvLon = view.findViewById(R.id.tv_lon)
        tvLat = view.findViewById(R.id.tv_lat)
        tvSeaLevel = view.findViewById(R.id.tv_sea_level)




        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        weatherService = retrofit.create(WeatherService::class.java)


        val cityId = arguments?.getString("cityId")
        if (cityId != null) {
            lifecycleScope.launch {
                val weatherData =
                    weatherService.getWeather(cityId, "c76a3e5fe352589acf83ce6384b0e0ac")

                updateUI(weatherData)
            }
        }
        else{

            lifecycleScope.launch {
                val weatherData =
                    weatherService.getWeather("745042", "c76a3e5fe352589acf83ce6384b0e0ac")

                updateUI(weatherData)
            }

        }


    }

    private fun updateUI(weatherData: WeatherData) {

        tvCityName.text = weatherData.name
        tvCurrentTemp.apply {
            text = (weatherData.main.temp - 273).toString() +"˚C"
            textSize = 58f
        }
        tvFeelsLike.apply {
            text = (weatherData.main.feels_like - 273).toString()+"˚C"
            textSize = 14f
        }
        tvHighestTemp.apply {
            text ="Max Temp: "+ (weatherData.main.temp_max - 273).toString()+"˚C"
            textSize = 14f
        }
        tvLowestTemp.apply {
            text = "Min Temp: "+(weatherData.main.temp_min - 273).toString()+"˚C"
            textSize = 14f
        }
        tvWindDeg.text = weatherData.wind.deg.toString()
        tvLon.text = weatherData.coord.lon.toString()
        tvLat.text = weatherData.coord.lat.toString()
        tvSeaLevel.text = weatherData.sealevel.toString()

    }
}



