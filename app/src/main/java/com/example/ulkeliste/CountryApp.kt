@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.ulkeliste

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ulkeliste.model.CountryModel
import com.example.ulkeliste.ui.CountryViewModel
import com.example.ulkeliste.ui.navigation.SetupNavGraph
import com.example.ulkeliste.ui.screens.HomePage


@Composable
fun CountryApp(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val navController = rememberNavController()



    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CountryTopAppBar(
                scrollBehavior = scrollBehavior,
                navigateUp = {navController.navigateUp()},


                )
        }

    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            SetupNavGraph(navController,it)



        }


    }

}

@Composable
fun CountryTopAppBar(navigateUp:()->Unit,scrollBehavior: TopAppBarScrollBehavior,modifier: Modifier = Modifier){
CenterAlignedTopAppBar(scrollBehavior = scrollBehavior,
    title = {Text(text = "Countries") },
    navigationIcon = {

        IconButton(onClick = { navigateUp() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }


    }
)


}