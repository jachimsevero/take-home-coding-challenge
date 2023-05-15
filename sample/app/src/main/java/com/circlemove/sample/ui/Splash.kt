package com.circlemove.sample.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "wait for 5 seconds")

        // Go to my favorite anime automatically after 10 seconds
        LaunchedEffect(Unit) {
            delay(timeMillis = 5000L)

            navController.navigate(route = "my_favorite_anime") {
                popUpTo(route = "splash") {
                    inclusive = true
                }
            }
        }
    }
}