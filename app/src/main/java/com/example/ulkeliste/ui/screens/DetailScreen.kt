package com.example.ulkeliste.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
    val country = navController.previousBackStackEntry
        ?.savedStateHandle
        ?.get<CountryModel>("country")
    val decimalFormat = DecimalFormat("#,###")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        country?.let {
            AsyncImage(
                modifier = Modifier.size(240.dp),

                contentScale = ContentScale.Fit,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(it.flags?.svg)
                    .decoderFactory(SvgDecoder.Factory())
                    .crossfade(true)
                    .build(),
                contentDescription ="flag"
            )
            Divider()
            InfoSection(
                modifier = Modifier.padding(8.dp),
                icon = R.drawable.worldd_removebg_preview, label ="Country Name" , text =it.name?.common ?:"Unknown"
            )
            InfoSection(icon = R.drawable.worldd_removebg_preview, label ="UN Member" , text = it.unMember.toString())
            InfoSection(icon = R.drawable.worldd_removebg_preview, label ="Population" , text = decimalFormat.format(it.population))

        }


        
    }
}