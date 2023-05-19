package com.circlemove.sample.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.circlemove.sample.theme.CoGray

@Composable
fun CustomText(
    text: String,
    color: Color = CoGray,
    textSize: TextUnit = 24.sp,
    paddingTop: Dp = 0.dp,
    paddingBottom: Dp = 0.dp,
    paddingStart: Dp = 8.dp,
    paddingEnd: Dp = 8.dp,
) {
    Text(
        text = text,
        color = color,
        fontSize = textSize,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = paddingTop, bottom = paddingBottom, start = paddingStart, end = paddingEnd),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}