package com.example.cupcake.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cupcake.CupcakeScreen
import com.example.cupcake.R
import com.example.cupcake.data.PreferencesManager
import com.example.cupcake.data.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DashboardScreen(navController: NavController) {
    val preferencesManager = PreferencesManager(LocalContext.current)
    var betSelected by rememberSaveable { mutableStateOf("")}
    var weatherDescription by rememberSaveable { mutableStateOf("") }
    var feelsLikeTemperature by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        try {
            val response = withContext(Dispatchers.IO) {
                // Assuming RetrofitClient is correctly set up to call OpenWeatherMap API
                RetrofitClient.instance.getDailyForecast("Mesa,US", "53c1e06df401200db96ac0cfd1d1ca72").execute()
            }

            if (response.isSuccessful) {
                // Assuming the second item (or another appropriate index based on the current time and response structure) in the list is tomorrow's weather
                // Note: You might need a more sophisticated way to determine the index for "tomorrow" based on the current time and how the forecasts are structured.
                response.body()?.list?.get(1)?.let { forecast -> // Adjusted index to 1 for simplicity
                    weatherDescription = forecast.weather.first().description
                    feelsLikeTemperature = "${(forecast.main.feels_like - 273.15).toInt()}°C"
                    Log.d("DashboardScreen", "Weather: $weatherDescription, $feelsLikeTemperature")
                }
            } else {
                Log.e("DashboardScreen", "Error fetching weather data")
            }
        } catch (e: Exception) {
            Log.e("DashboardScreen", "Exception in fetching")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(com.example.cupcake.ui.theme.md_theme_light_primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Weather Gambler",
            fontSize = 30.sp,
            color = com.example.cupcake.ui.theme.text_white,
            modifier = Modifier.padding(top = 40.dp, bottom = 100.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Tomorrow's Weather",
                    color = com.example.cupcake.ui.theme.text_white,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.sun),
                    contentDescription = "Sun Image"
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = weatherDescription,
                        fontSize = 30.sp,
                        color = com.example.cupcake.ui.theme.text_white,
                        modifier = Modifier.padding(vertical = 8.dp),
                    )
                    Text(
                        text = " - ",
                        fontSize = 30.sp,
                        color = com.example.cupcake.ui.theme.text_white,
                        modifier = Modifier.padding(vertical = 8.dp),
                    )
                    Text(
                        text = feelsLikeTemperature,
                        fontSize = 30.sp,
                        color = com.example.cupcake.ui.theme.text_white,
                        modifier = Modifier.padding(vertical = 8.dp),
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(100.dp))

        Column {
            RadioButtonComponent(preferencesManager = preferencesManager)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate(CupcakeScreen.Weather.name) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = com.example.cupcake.ui.theme.md_theme_light_tertiary
            )
        ) {
            Text(
                fontSize = 20.sp,
                text = "Instructions"
            )
        }
    }
}

@Composable
fun RadioButtonComponent(preferencesManager: PreferencesManager) {
    val context = LocalContext.current
    val filledID = R.drawable.filled
    val emptyID = R.drawable.empty

    // Use collectAsState to observe changes in the preference and update the UI accordingly
    val selectedBet by preferencesManager.selectedBet.collectAsState(initial = "")

    // Determine button states based on the stored preference
    val yesBtnState = if (selectedBet == "Yes") filledID else emptyID
    val noBtnState = if (selectedBet == "No") filledID else emptyID

    Column {
        Button(
            onClick = {
                // Update the preference when the button is clicked
                CoroutineScope(Dispatchers.IO).launch {
                    preferencesManager.setSelectedBet(if (selectedBet != "Yes") "Yes" else "")
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp),
                    painter = painterResource(id = yesBtnState),
                    contentDescription = "Yes Radio Button"
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    text = "Bet the Weather is going to be incorrect",
                    color = com.example.cupcake.ui.theme.text_white)
            }
        }
        Button(
            onClick = {
                // Update the preference when the button is clicked
                CoroutineScope(Dispatchers.IO).launch {
                    preferencesManager.setSelectedBet(if (selectedBet != "No") "No" else "")
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .height(20.dp)
                        .width(20.dp),
                    painter = painterResource(id = noBtnState),
                    contentDescription = "No Radio Button"
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    text = "Bet the Weather is not going to be incorrect",
                    color = com.example.cupcake.ui.theme.text_white)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    // Mock NavController for preview
    val navController = NavController(LocalContext.current)

    DashboardScreen(navController = navController)
}



