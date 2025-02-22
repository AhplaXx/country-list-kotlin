package com.example.ulkeliste.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ulkeliste.R
import com.example.ulkeliste.model.CountryModel
import com.example.ulkeliste.ui.CountryViewModel
import com.example.ulkeliste.ui.components.InfoSection


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
        //Flag Image
        Box(
            modifier = Modifier){
        }

        country?.let {
            InfoSection(
                modifier = Modifier.padding(8.dp),
                icon = R.drawable.worldd_removebg_preview, label ="Country Name" , text =it.name?.common ?:"Unknown"
            )
            InfoSection(icon = R.drawable.worldd_removebg_preview, label ="UN Member" , text = it.unMember.toString())
        }


        
    }
}