package com.example.ulkeliste.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.ulkeliste.model.CountryModel
import com.example.ulkeliste.ui.CountryViewModel


@Composable
fun DetailScreen(navController: NavController){
    val country = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<CountryModel>("country")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("DETAIL SCREEN")
        country?.let {
            Text(text = it.name?.common ?: "Bilinmiyor")
        }


        
    }
}