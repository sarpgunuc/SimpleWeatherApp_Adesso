package com.addeso.simpleweatherapp.Activites

data class WeatherData(
    val id: Int,
    val name: String,
    val main: Main,
    val wind: Wind,
    val coord: Coord,
    val sealevel: Int,

)

data class Main(
    val temp: Float,
    val feels_like: Float,
    val temp_min : Float,
    val temp_max: Float,
    val humidity: Int
)

data class Wind(
    val speed: Float,
    val deg: Int
)

data class Coord(
    val lon: Float,
    val lat: Float
)

