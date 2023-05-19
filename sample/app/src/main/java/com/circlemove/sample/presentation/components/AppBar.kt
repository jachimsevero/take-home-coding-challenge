package com.circlemove.sample.presentation.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.circlemove.sample.theme.CoDirtyWhite
import com.circlemove.sample.theme.CoOceanBlue

@Composable
fun AppBar(
    title: String,
    onBackPressed: () -> Unit
) {
    TopAppBar(
        backgroundColor = CoOceanBlue,
        title = {
            Text(
                text = title,
                color = CoDirtyWhite,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(Icons.Default.ArrowBack, contentDescription = null, tint = CoDirtyWhite)
            }
        }
    )
}