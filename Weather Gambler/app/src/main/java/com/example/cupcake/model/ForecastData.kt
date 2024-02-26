package com.example.cupcake.model

data class ForecastData(
    val data: List<ForecastDay>
)

data class ForecastDay(
    val temp: Double,
    val weather: Weather
)

data class Weather(
    val description: String
)
