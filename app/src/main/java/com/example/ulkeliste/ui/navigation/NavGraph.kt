package com.example.ulkeliste.ui.navigation

import android.app.Activity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ulkeliste.ui.CountryUiState
import com.example.ulkeliste.ui.CountryViewModel
import com.example.ulkeliste.ui.screens.DetailScreen
import com.example.ulkeliste.ui.screens.FirstPage
import com.example.ulkeliste.ui.screens.HomePage


@Composable
fun SetupNavGraph(navController: NavHostController,contentPadding: PaddingValues) {
    val countryViewModel : CountryViewModel = viewModel(factory = CountryViewModel.Factory)
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = "firstPage") {
        composable(route = "firstPage") {
            FirstPage(
                onNextButtonClicked = {navController.navigate("homePage")},
                onExitButtonClicked = { (context as? Activity)?.finish() }
            )
        }
        composable(route = "homePage") {
            HomePage(
                countryUiState = countryViewModel.countryUiState,
                onClick = { country ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("country", country)
                    navController.navigate("detailPage")
                },
                modifier = Modifier,
                contentPadding = contentPadding
            )


        }
        composable(route = "detailPage"){
            DetailScreen(
                navController

            )
        }


    }
}