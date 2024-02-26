package com.example.cupcake.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cupcake.CupcakeScreen

@Composable
fun DashboardScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Weather",
            color = com.example.cupcake.ui.theme.text_black,
            modifier = Modifier.padding(bottom = 40.dp,
                                        top = 40.dp)
        )

        Button(
            onClick = { navController.navigate(CupcakeScreen.Weather.name) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Go to previous results")
        }
    }
}
