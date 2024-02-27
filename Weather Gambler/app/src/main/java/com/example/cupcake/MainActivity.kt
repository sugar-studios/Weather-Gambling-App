
package com.example.cupcake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cupcake.ui.theme.CupcakeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CupcakeTheme {
                CupcakeApp()
            }
        }
    }
}

/*
this is the my api url: https://api.weatherbit.io/v2.0/forecast/daily?city=Phoenix,AZ&key=e932f12ab1cf4ec0b3c81e0f61a506a9", the json it returns looks something like this: "{"city_name":"Phoenix","country_code":"US","data":[{"app_max_temp":22.8,"app_min_temp":14.3,"clouds":42,"clouds_hi":83,"clouds_low":3,"clouds_mid":13,"datetime":"2024-02-27","dewpt":5.8,"high_temp":24.1,"low_temp":11.7,"max_dhi":null,"max_temp":24.1,"min_temp":13.4,"moon_phase":0.855258,"moon_phase_lunation":0.61,"moonrise_ts":1709091111,"moonset_ts":1709049475,"ozone":343.1,"pop":0,"precip":0,"pres":972.3,"rh":44,"slp":1011.6,"snow":0,"snow_depth":0,"sunrise_ts":1709042331,"sunset_ts":1709083382,"temp":18.8,"ts":1709017260,"uv":5.3,"valid_date":"2024-02-27","vis":5.391,"weather":{"description":"Broken clouds","code":803,"icon":"c03d"},"wind_cdir":"SW","wind_cdir_full":"southwest","wind_dir":220,"wind_gust_spd":3.1,"wind_spd":2},{"app_max_temp":22.8,"app_min_temp":12.2,"clouds":30,"clouds_hi":23,"clouds_low":13,"clouds_mid":42,"datetime":"2024-02-28","dewpt":6.8,"high_temp":24.8,"low_temp":10.5,"max_dhi":null,"max_temp":24.8,"min_temp":11.7,"moon_phase":0.780452,"moon_phase_lunation":0.65,"moonrise_ts":1709180822,"moonset_ts":1709137462,"ozone":370.9,"pop":0,"precip":0,"pres":975.7,"rh":52,"slp":1015.4,"snow":0,"snow_depth":0,"sunrise_ts":1709128659,"sunset_ts":1709169833,"temp":17.5,"ts":1709103660,"uv":4.8,"valid_date":"2024-02-28","vis":19.643,"weather":{"description":"Scattered clouds","code":802,"icon":"c02d"},"wind_cdir":"ESE","wind_cdir_full":"east-southeast","wind_dir":120,"wind_gust_spd":3.3,"wind_spd":2.2},{"app_max_temp":22.6,"app_min_temp":11.7,"clouds":8,"clouds_hi":0,"clouds_low":1,"clouds_mid":3,"datetime":"2024-02-29","dewpt":7.5,"high_temp":24.3,"low_temp":11.6,"max_dhi":null,"max_temp":24.3,"min_temp":10.5,"moon_phase":0.693131,"moon_phase_lunation":0.68,"moonrise_ts":1709270620,"moonset_ts":1709225672,"ozone":323.1,"pop":0,"precip":0,"pres":973.5,"rh":55,"slp":1013,"snow":0,"snow_depth":0,"sunrise_ts":1709214987,"sunset_ts":1709256282,"temp":17.4,"ts":1709190060,"uv":6,"valid_date":"2024-02-29","vis":21.545,"weather":{"description":"Few clouds","code":801,"icon":"c02d"},"wind_cdir":"SSE","wind_cdir_full":"south-southeast","wind_dir":153,"wind_gust_spd":2.6,"wind_spd":1.7},{"app_max_temp":24.5,"app_min_temp":12.2,"clouds":5,"clouds_hi":0,"clouds_low":0,"clouds_mid":0,"datetime":"2024-03-01","dewpt":5.5,"high_temp":26.3,"low_temp":11.8,"max_dhi":null,"max_temp":26.3,"min_temp":11.6,"moon_phase":0.595281,"moon_phase_lunation":0.72,"moonrise_ts":1709360552,"moonset_ts":1709314215,"ozone":320.4,"pop":0,"precip":0,"pres":970.1,"rh":45,"slp":1009,"snow":0,"snow_depth":0,"sunrise_ts":1709301314,"sunset_ts":1709342732,"temp":18.6,"ts":1709276460,"uv":6.2,"valid_date":"2024-03-01","vis":24.128,"weather":{"description":"Few clouds","code":801,"icon":"c02d"},"wind_cdir":"SSE","wind_cdir_full":"south-southeast","wind_dir":149,"wind_gust_spd":4.2,"wind_spd":2.8},{"app_max_temp":21.9,"app_min_temp":12.4,"clouds":5,"clouds_hi":0,"clouds_low":0,"clouds_mid":0,"datetime":"2024-03-02","dewpt":4.2,"high_temp":24.1,"low_temp":10.6,"max_dhi":null,"max_temp":24.1,"min_temp":11.8,"moon_phase":0.489562,"moon_phase_lunation":0.75,"moonrise_ts":1709364239,"moonset_ts":1709403210,"ozone":322.2,"pop":0,"precip":0,"pres":967.8,"rh":42,"slp":1006.8,"snow":0,"snow_depth":0,"sunrise_ts":1709387640,"sunset_ts":1709429181,"temp":17.7,"ts":1709362860,"uv":6.2,"valid_date":"2024-03-02","vis":24.128,"weather":{"description":"Few clouds","code":801,"icon":"c02d"},"wind_cdir":"SSW","wind_cdir_full":"south-southwest","wind_dir":202,"wind_gust_spd":6.6,"wind_spd":4.5},{"app_max_temp":20.1,"app_min_temp":11.4,"clouds":17,"clouds_hi":0,"clouds_low":9,"clouds_mid":0,"datetime":"2024-03-03","dewpt":1.8,"high_temp":21.3,"low_temp":9.1,"max_dhi":null,"max_temp":21.3,"min_temp":10.6,"moon_phase":0.379771,"moon_phase_lunation":0.78,"moonrise_ts":1709454446,"moonset_ts":1709492759,"ozone":340.3,"pop":0,"precip":0,"pres":966.6,"rh":41,"slp":1006,"snow":0,"snow_depth":0,"sunrise_ts":1709473966,"sunset_ts":1709515630,"temp":15.7,"ts":1709449260,"uv":6.8,"valid_date":"2024-03-03","vis":24.128,"weather":{"description":"Few clouds","code":801,"icon":"c02d"},"wind_cdir":"WSW","wind_cdir_full":"west-southwest","wind_dir":247,"wind_gust_spd":5.8,"wind_spd":4.6},{"app_max_temp":19.6,"app_min_temp":9.1,"clouds":6,"clouds_hi":25,"clouds_low":0,"clouds_mid":0,"datetime":"2024-03-04","dewpt":-1.2,"high_temp":20.9,"low_temp":8.6,"max_dhi":null,"max_temp":20.9,"min_temp":9.1,"moon_phase":0.271309,"moon_phase_lunation":0.82,"moonrise_ts":1709544663,"moonset_ts":1709582885,"ozone":326.7,"pop":0,"precip":0,"pres":967.8,"rh":35,"slp":1007.1,"snow":0,"snow_depth":0,"sunrise_ts":1709560291,"sunset_ts":1709602078,"temp":14.9,"ts":1709535660,"uv":6.8,"valid_date":"2024-03-04","vis":24.128,"weather":{"description":"Few clouds","code":801,"icon":"c02d"},"wind_cdir":"SW","wind_cdir_full":"southwest","wind_dir":226,"wind_gust_spd":2.8,"wind_spd":2.8}],"lat":"33.44838","lon":"-112.07404","state_code":"AZ","timezone":"America/Phoenix"}"




This is my DashboardScreen.kt file in android studio: "package com.example.cupcake.ui

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
                        Spacer(modifier = Modifier.height(8.dp))
                        if (item == 1)
                        {
                            Text(text = "Today")
                        }
                        else if (item == 2)
                        {
                            Text(text = "Tomorrow")
                        }
                        else if (item == 3)
                        {
                            Text(text = "Overmorrow")
                        }

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
}",

What I want to do is call the api I showed you earilier and replace the "item" text on my row to display the temature and the description of the weather for that day (today, tomorrow, and overmorrow). Create and update all required files to do this, and give them to me (including modifcations to the gradle)
 */
