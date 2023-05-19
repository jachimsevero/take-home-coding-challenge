package com.circlemove.sample.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.circlemove.sample.presentation.ui.*
import com.circlemove.sample.presentation.ui.buyticket.BuyTicketScreen
import com.circlemove.sample.presentation.ui.menu.MenuScreen
import com.circlemove.sample.theme.Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Theme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = ScreenList.SplashScreen.route) {
                    composable(route = ScreenList.SplashScreen.route) {
                        Splash(navController)
                    }

                    composable(route = ScreenList.MenuScreen.route) {
                        MenuScreen(navController)
                    }

                    composable(route = ScreenList.BuyTicketScreen.route) {
                        BuyTicketScreen(navController)
                    }

                    composable(route = "one_punch_man") {
                        OnePunchMan()
                    }

                    composable(route = "done") {
                        Text(text = "done")
                    }
                }
            }
        }
    }
}