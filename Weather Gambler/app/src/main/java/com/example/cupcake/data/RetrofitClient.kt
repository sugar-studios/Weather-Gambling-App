package com.example.cupcake.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    class RetrofitClient {
        private val BASE_URL = "https://api.weatherbit.io/v2.0/"

        val instance: WeatherService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(WeatherService::class.java)
        }
    }


object WeatherApi {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val service by lazy {
        retrofit.create(WeatherService::class.java)
    }

    suspend fun fetchCurrentWeather(apiKey: String, latitude: Double, longitude: Double): WeatherResponse? {
        return try {
            service.getCurrentWeather(latitude, longitude, apiKey)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun fetchDailyForecast(apiKey: String, city: String): WeatherResponse? {
        return try {
            service.getDailyForecast(city, apiKey)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}
}