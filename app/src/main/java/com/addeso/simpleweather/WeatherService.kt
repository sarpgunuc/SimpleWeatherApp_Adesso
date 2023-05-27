package com.addeso.simpleweather

import com.addeso.simpleweatherapp.Activites.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    suspend fun getWeather(
        @Query("id") cityId: String,
        @Query("units") units: String = "metric",
        @Query("APPID") apiKey: String = "c76a3e5fe352589acf83ce6384b0e0ac"
    ): WeatherData
}
