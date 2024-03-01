package com.example.cupcake.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cupcake.CupcakeScreen
import com.example.cupcake.R

@Composable
fun ResultsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(com.example.cupcake.ui.theme.md_theme_light_surfaceVariant)
    ) {

        Text(
            text = "INSTRUCTIONS",
            color = com.example.cupcake.ui.theme.text_white,
            modifier = Modifier
                .padding(bottom = 40.dp, top = 40.dp),
            fontSize = 30.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp),
                painter = painterResource(id = R.drawable.tut1),
                contentDescription = "Tutorial picture 1"
            )
        }
        Text(
            text = "Its so simple! What you see is an image, a descrition, and tempature relating to the predicted weather for today!",
            color = com.example.cupcake.ui.theme.text_white,
            modifier = Modifier
                .padding(bottom = 40.dp, top = 40.dp),
            fontSize = 20.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp),
                painter = painterResource(id = R.drawable.tut2),
                contentDescription = "Tutorial picture 2"
            )
        }
        Text(
            text = "You can accecpt this information as it is or bet (gentlemen's bet) on if the weather is going to be correct or not.",
            color = com.example.cupcake.ui.theme.text_white,
            modifier = Modifier
                .padding(bottom = 40.dp, top = 40.dp),
            fontSize = 20.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp),
                painter = painterResource(id = R.drawable.tut3),
                contentDescription = "Tutorial picture 3"
            )
        }
        Text(
            text = "As they say, the weather man is always wrong. But they also say the house always wins!",
            color = com.example.cupcake.ui.theme.text_white,
            modifier = Modifier
                .padding(bottom = 40.dp, top = 40.dp),
            fontSize = 20.sp,
        )

        Button(
            onClick = { navController.navigate(CupcakeScreen.Home.name) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Go to Main Dashboard")
        }
        Text(text = "made by Alex",
                color = com.example.cupcake.ui.theme.text_white)
    }
}
