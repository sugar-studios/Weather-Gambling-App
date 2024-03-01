package com.example.cupcake.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cupcake.CupcakeScreen

@Composable
fun PastGamblesScreen(navController: NavController) {
    Text(text = "[Past Gambling]")
    Button(
        onClick = { navController.navigate(CupcakeScreen.Home.name) },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Text("Go to Main Dashboard")
    }
}