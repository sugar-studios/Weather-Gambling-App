package com.example.cupcake.ui

import android.annotation.SuppressLint
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
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.cupcake.network.ApiService
import kotlinx.coroutines.launch
import com.example.cupcake.data.RetrofitClient

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DashboardScreen(navController: NavController) {
    var selectedValue by rememberSaveable { mutableStateOf("") }
    var weatherJSON by rememberSaveable { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            // Corrected access to the fetchDailyForecast method
            val response = RetrofitClient.WeatherApi.fetchDailyForecast("e932f12ab1cf4ec0b3c81e0f61a506a9", "Phoenix,AZ")
            weatherJSON = response?.toString() ?: "Failed to fetch weather data"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(com.example.cupcake.ui.theme.md_theme_light_primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Your UI elements here

        Text(text = "Fetched JSON: $weatherJSON")

        // The rest of your DashboardScreen content
    }

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
                        text = "Weather Desc",
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
                        text = "temp",
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


