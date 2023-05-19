package com.circlemove.sample.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.circlemove.sample.presentation.ui.*
import com.circlemove.sample.presentation.ui.buyticket.BuyTicketScreen
import com.circlemove.sample.presentation.ui.menu.MenuScreen
import com.circlemove.sample.presentation.ui.results.ResultsScreen
import com.circlemove.sample.presentation.ui.ticketconfirmation.TicketConfirmationScreen
import com.circlemove.sample.theme.Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleActivity : ComponentActivity() {

    val viewModel: SimpleActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            this.setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        setContent {
            Theme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = ScreenList.MenuScreen.route) {
                    composable(route = ScreenList.MenuScreen.route) {
                        MenuScreen(navController)
                    }

                    composable(route = ScreenList.BuyTicketScreen.route) {
                        BuyTicketScreen(navController)
                    }

                    composable(route = ScreenList.TicketConfirmationScreen.route) {
                        TicketConfirmationScreen(navController)
                    }

                    composable(route = ScreenList.ResultsScreen.route) {
                        ResultsScreen(navController)
                    }
                }
            }
        }
    }
}