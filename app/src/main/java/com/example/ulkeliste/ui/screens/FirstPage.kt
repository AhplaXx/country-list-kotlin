package com.example.ulkeliste.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ulkeliste.R


@Composable
fun FirstPage(
    modifier: Modifier = Modifier,
    onNextButtonClicked: () -> Unit,
    onExitButtonClicked:()->Unit
){
    val robotoFontFamily = FontFamily(

        Font(R.font.jetbrains_medium,FontWeight.Medium),
        Font(R.font.jetbrains_semibold,FontWeight.SemiBold)
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF2973B2))
    ) {
        Text(text = "Welcome to Countries!", lineHeight = 38.sp,fontSize = 30.sp, fontWeight = FontWeight.SemiBold, fontFamily = robotoFontFamily,color = Color(0xFFFFFFFF), textAlign = TextAlign.Center, modifier = Modifier.width(200.dp))
        Image(painter = painterResource(id = R.drawable.worldd_removeb), contentDescription ="world_logo" )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { onNextButtonClicked() },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF48A6A7),
                contentColor = Color(0xFFF2EFE7)

            ),
            modifier = Modifier
                .width(270.dp)
                .height(60.dp)
        ){

            Text(text = "Go to Countries", fontSize = 22.sp, fontFamily = robotoFontFamily, fontWeight = FontWeight.Medium)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { onExitButtonClicked() },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF48A6A7),
                contentColor = Color(0xFFF2EFE7)

            ),
            modifier = Modifier
                .width(270.dp)
                .height(60.dp)
        ){

            Text(text = "Exit", fontSize = 22.sp, fontFamily = robotoFontFamily, fontWeight = FontWeight.Medium)
        }
    }

}