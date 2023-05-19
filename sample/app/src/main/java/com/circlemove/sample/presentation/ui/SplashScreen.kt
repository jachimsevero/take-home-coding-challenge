package com.circlemove.sample.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.circlemove.sample.R
import com.circlemove.sample.presentation.ScreenList
import com.circlemove.sample.theme.CoDarkBlue
import com.circlemove.sample.theme.CoDirtyWhite
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(CoDirtyWhite)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp), // Adjust the padding as needed
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.app_logo),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )

                Text(
                    text = stringResource(id = R.string.app_name),
                    color = CoDarkBlue,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )

                LaunchedEffect(Unit) {
                    delay(timeMillis = 3000L)

                    navController.navigate(route = ScreenList.MenuScreen.route) {
                        popUpTo(route = ScreenList.SplashScreen.route) {
                            inclusive = true
                        }
                    }
                }
            }
        }
    }
}