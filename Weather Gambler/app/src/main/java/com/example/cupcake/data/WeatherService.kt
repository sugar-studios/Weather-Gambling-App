package com.example.cupcake.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("forecast")
    fun getDailyForecast(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): Call<OpenWeatherResponse>
}
