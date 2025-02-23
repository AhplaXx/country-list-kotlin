package com.example.ulkeliste.ui.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun InfoSection(
    icon: Int,
    label:String,
    text:String,
    modifier: Modifier = Modifier
){
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(

            containerColor = Color(0xFF2973B2),
            contentColor = Color(0xFFF2EFE7)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentScale = ContentScale.Fit,
                contentDescription = "",
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 4.dp)
                    .size(32.dp)
            )
            Column(
                modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                Text(text = label, fontWeight = FontWeight.Bold, color = Color(0xFFF2EFE7))
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = text)
            }
        }
    }

}