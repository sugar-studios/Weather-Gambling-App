package com.example.cupcake.network;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiService {
    public static String fetchJsonData() {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.weatherbit.io/v2.0/forecast/daily?city=Pheonix,AZ&key=e932f12ab1cf4ec0b3c81e0f61a506a9"; // Replace with your actual API URL
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            return "{}"; // Return an empty JSON object in case of failure
        }
    }
}
