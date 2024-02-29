package com.example.cupcake.data

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    // Existing method for fetching current weather
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String
    ): WeatherResponse

    // New method for fetching daily forecast from Weatherbit
    @GET("forecast/daily")
    suspend fun getDailyForecast(
        @Query("city") city: String,
        @Query("key") apiKey: String
    ): WeatherResponse // Ensure WeatherResponse is structured to parse the JSON response from Weatherbit
}
