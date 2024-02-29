package com.example.cupcake.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

object ApiService {
    suspend fun fetchJsonData(): String = withContext(Dispatchers.IO) {
        val client = OkHttpClient()
        val url = "https://api.weatherbit.io/v2.0/forecast/daily?city=Pheonix,AZ&key=YOUR_API_KEY" // Replace YOUR_API_KEY with your actual API key
        val request = Request.Builder()
            .url(url)
            .build()

        try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                response.body?.string() ?: "{}" // Return an empty JSON object in case of failure or null body
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "{}" // Return an empty JSON object in case of failure
        }
    }
}
