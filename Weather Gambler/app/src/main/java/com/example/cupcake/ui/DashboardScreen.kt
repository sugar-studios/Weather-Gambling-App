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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cupcake.CupcakeScreen
import com.example.cupcake.R
import com.example.cupcake.data.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DashboardScreen(navController: NavController) {
    var SelectedBet by rememberSaveable { mutableStateOf("") }
    var weatherDescription by rememberSaveable { mutableStateOf("") }
    var feelsLikeTemperature by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        try {
            val response = withContext(Dispatchers.IO) {
                RetrofitClient.instance.getDailyForecast("Mesa,US", "53c1e06df401200db96ac0cfd1d1ca72").execute()
            }

            if (response.isSuccessful) {
                // Assuming the first item in the list is the current weather
                response.body()?.list?.get(0)?.let { forecast ->
                    weatherDescription = forecast.weather.first().description
                    feelsLikeTemperature = "${"%.1f".format(forecast.main.feels_like - 273.15)}°C"
                    Log.d("DashboardScreen", "Weather: $weatherDescription, $feelsLikeTemperature")
                }
            } else {
                Log.e("DashboardScreen", "Error fetching weather data")
            }
        } catch (e: Exception) {
            Log.e("DashboardScreen", "Exception in fetching weather data", e)
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
                    text = "Today's Weather",
                    color = com.example.cupcake.ui.theme.text_white,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.sun),
                    contentDescription = "Sun Image",
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
            RadioButtonComponent()
        }

        Spacer(modifier = Modifier.height(200.dp))

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
fun RadioButtonComponent() {
    val radioOptions = listOf("Yes", "No") // Assuming you meant to use these as separate options
    val filledID = R.drawable.filled
    val emptyID = R.drawable.empty
    var yesBtnState by rememberSaveable { mutableStateOf(emptyID) }
    var noBtnState by rememberSaveable { mutableStateOf(emptyID) }

    Column {
        Button(
            onClick = {
                yesBtnState = if (yesBtnState == emptyID) filledID else emptyID
                noBtnState = emptyID // Ensure only one can be selected at a time
            }
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
        }
        Button(
            onClick = {
                noBtnState = if (noBtnState == emptyID) filledID else emptyID
                yesBtnState = emptyID // Ensure only one can be selected at a time
            }
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


