package com.example.cupcake.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cupcake.CupcakeScreen
import com.example.cupcake.R

@Composable
fun DashboardScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Weather",
                color = com.example.cupcake.ui.theme.text_black,
                modifier = Modifier.padding(top = 40.dp, bottom = 40.dp)
            )
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Repeating the Column for each item. You should customize each item as needed.
                (1..3).forEach { item ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        // Placeholder for an image. Replace R.drawable.placeholder with your actual image resource
                        Image(
                            painter = painterResource(id = R.drawable.cupcake),
                            contentDescription = "Item $item",
                            modifier = Modifier.size(64.dp) // Adjust the size as needed
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Item $item")
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(40.dp))
        }

        item {
            Button(
                onClick = { navController.navigate(CupcakeScreen.Weather.name) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 25.dp) // Adjusted to align with LazyColumn padding
            ) {
                Text("Go to previous results")
            }
        }
    }
}
