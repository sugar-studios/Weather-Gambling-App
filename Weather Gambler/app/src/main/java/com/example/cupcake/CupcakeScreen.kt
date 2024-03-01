
package com.example.cupcake

import android.content.Context
import android.content.Intent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cupcake.ui.DashboardScreen
import com.example.cupcake.ui.ResultsScreen
import com.example.cupcake.ui.PastGamblesScreen
import com.example.cupcake.ui.CreditsScreen

/**
 * enum values that represent the screens in the app
 */
enum class CupcakeScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Instructions(title = R.string.app_name),
    Results(title = R.string.app_name),
    Credits(title = R.string.app_name)
}

@Composable
fun CupcakeApp(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = DashboardScreen(navController = navController)

    Scaffold(
        topBar = {
            Text(text = "Test")
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = CupcakeScreen.Home.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = CupcakeScreen.Home.name) {
                DashboardScreen(navController = navController)
            }
            composable(route = CupcakeScreen.Instructions.name) {
                ResultsScreen(navController = navController)
            }
            composable(route = CupcakeScreen.Results.name) {
                PastGamblesScreen(navController = navController)
            }
            composable(route = CupcakeScreen.Credits.name) {
                CreditsScreen(navController = navController)
            }
        }
    }
}
