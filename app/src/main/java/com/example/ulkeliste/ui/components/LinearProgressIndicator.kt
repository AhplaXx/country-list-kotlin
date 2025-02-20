package com.example.ulkeliste.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RoundedLinearProgressIndicator(
    progress: Float,
    color: Color = Color.Blue,
    trackColor: Color = Color.Cyan
) {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(12.dp)
    ) {
        val cornerRadius = size.height / 3 // Yükseklik kadar köşe yarıçapı
        // Arkaplan track
        drawRoundRect(
            color = trackColor,
            size = size,
            cornerRadius = CornerRadius(cornerRadius)
        )
        // İlerleme çizgisi
        drawRoundRect(
            color = color,
            size = size.copy(width = size.width * progress),
            cornerRadius = CornerRadius(cornerRadius)
        )
    }
}