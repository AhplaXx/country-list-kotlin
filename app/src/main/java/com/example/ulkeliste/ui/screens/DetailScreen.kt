package com.example.ulkeliste.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.ulkeliste.R
import com.example.ulkeliste.model.CountryModel
import com.example.ulkeliste.ui.CountryViewModel
import com.example.ulkeliste.ui.components.InfoSection
import java.text.DecimalFormat


@Composable
fun DetailScreen(navController: NavController){
    val scrollState = rememberScrollState()
    val country = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<CountryModel>("country")
    val decimalFormat = DecimalFormat("#,###")

    Column(
        modifier = Modifier.fillMaxSize().background(color = Color(0xFFF2EFE7)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        country?.let {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(240.dp)
                        .padding(horizontal = 14.dp),

                    contentScale = ContentScale.Fit,
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(it.flags?.svg)
                        .decoderFactory(SvgDecoder.Factory())
                        .crossfade(true)
                        .build(),
                    contentDescription ="flag"
                )
                AsyncImage(
                    modifier = Modifier.size(240.dp),
                    contentScale = ContentScale.Fit,
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(it.coatOfArms?.svg)
                        .decoderFactory(SvgDecoder.Factory())
                        .crossfade(true)
                        .build(),
                    contentDescription = "CoatOfArms"
                )

            }

            Divider()
            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                InfoSection(
                    modifier = Modifier.padding(8.dp),
                    icon = R.drawable.worldd_removebg_preview, label ="Country Name" , text =it.name?.common ?:"Unknown"
                )
                InfoSection(icon = R.drawable.un_removebg_preview, label ="UN Member" , text = if(it.unMember == true){"Yes"}else{"No"})
                InfoSection(icon = R.drawable.lang_removebg_preview, label ="Population" , text = decimalFormat.format(it.population))
                InfoSection(icon =R.drawable.lang_removebg_preview , label = "Capital(s)", text = it.capital.joinToString ( ", " ))
                InfoSection(icon = R.drawable.worldd_removebg_preview, label ="Region" , text = it.region)
            }

        }
        Spacer(modifier = Modifier.height(0.dp))
        Text(text = "Data from restcountries.com", color = Color.Gray)


        
    }
}