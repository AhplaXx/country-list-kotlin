package com.example.ulkeliste.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ulkeliste.R
import com.example.ulkeliste.model.CountryModel
import com.example.ulkeliste.ui.CountryUiState
import com.example.ulkeliste.ui.components.RoundedLinearProgressIndicator
import kotlinx.coroutines.delay


@Composable
fun HomePage(
    countryUiState: CountryUiState,
    onClick: (CountryModel) -> Unit,
    modifier : Modifier = Modifier,
    contentPadding:PaddingValues = PaddingValues(0.dp)
){
    when(countryUiState){

        is CountryUiState.Loading -> LoadingScreen()
        is CountryUiState.Success -> CountryGridScreen(countries = countryUiState.countries,onClick =onClick)
        is CountryUiState.Error -> Text(text = "Error")
    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryCard(country: CountryModel,onClick: () -> Unit, modifier: Modifier = Modifier) {
    val robotoFontFamily = FontFamily(
        Font(R.font.roboto_regular,FontWeight.Normal),
        Font(R.font.roboto_semibold,FontWeight.SemiBold)
    )

    Card(
        modifier = Modifier.padding(6.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF2EFE7),
            contentColor = Color(0xFF2973B2)
        ),
        onClick = onClick


    ) {
        Row(
            modifier = Modifier
                .padding(top = 12.dp, bottom = 12.dp, start = 4.dp, end = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {
            Text(
                text = country.name?.common!!,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontFamily = robotoFontFamily,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun CountryGridScreen(
    countries: List<CountryModel>,
    modifier: Modifier = Modifier,
    onClick: (CountryModel) -> Unit,
    contentPadding: PaddingValues =PaddingValues(8.dp),
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(columns = GridCells.Fixed(1),modifier = Modifier.padding(top = 40.dp, start = 10.dp, end = 10.dp, bottom = 40.dp), contentPadding = contentPadding) {
            items(
                items = countries.sortedBy { it.name?.common },
                key = { country -> country.name?.common?: "" } //Null Check :)
            ) { country ->
                CountryCard(
                    country = country,
                    modifier = modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .aspectRatio(3f),
                    onClick = {onClick(country)}

                )
            }
        }


    }

}

@Composable
fun LoadingScreen(){
    var progress by remember{ mutableStateOf(0f) }
    LaunchedEffect(Unit) {
        while(progress<1f){
            progress+=0.01f
            delay(50)
        }
        
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RoundedLinearProgressIndicator(progress = progress, color = Color(0xFF2973B2), trackColor = Color(0xFFF2EFE7))

    }
}



