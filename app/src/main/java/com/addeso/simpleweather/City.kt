package com.addeso.simpleweather

data class City(
    val id: Int,
    val name: String,
    val state: String,
    val country: String,
    val coord: Coord
)

data class Coord(
    val lon: Double,
    val lat: Double
)

