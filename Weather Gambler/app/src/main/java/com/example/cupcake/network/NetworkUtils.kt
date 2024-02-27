package com.example.cupcake.network

import com.example.cupcake.model.ForecastDay
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

object NetworkUtils {

    fun fetchWeatherForecast(apiKey: String, lat: Double, lon: Double, days: Int, onSuccess: (String) -> Unit, onError: (Exception) -> Unit) {
        Thread {
            var urlConnection: HttpsURLConnection? = null
            try {
                val url = URL("https://api.weatherbit.io/v2.0/forecast/daily?lat=$lat&lon=$lon&days=$days&key=$apiKey")
                urlConnection = url.openConnection() as HttpsURLConnection
                urlConnection.requestMethod = "GET"
                urlConnection.connect()

                val inputStream = urlConnection.inputStream
                val bufferedReader = BufferedReader(InputStreamReader(inputStream))
                val response = bufferedReader.readText()

                onSuccess(response)
            } catch (e: Exception) {
                onError(e)
            } finally {
                urlConnection?.disconnect()
            }
        }.start()
    }

    fun parseWeatherForecastJson(jsonString: String): List<ForecastDay> {
        val jsonObject = JSONObject(jsonString)
        val jsonArray = jsonObject.getJSONArray("data")
        val forecastList = mutableListOf<ForecastDay>()

        for (i in 0 until jsonArray.length()) {
            val dayObject = jsonArray.getJSONObject(i)
            val temp = dayObject.getDouble("temp")
            val weatherObject = dayObject.getJSONObject("weather")
            val description = weatherObject.getString("description")
            forecastList.add(ForecastDay(temp, description))
        }

        return forecastList
    }
}
