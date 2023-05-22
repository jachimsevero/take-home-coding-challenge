package com.circlemove.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.circlemove.sample.theme.Theme
import com.circlemove.sample.ui.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Theme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = "splash") {
                    composable(route = "splash") {
                        Splash(navController)
                    }

                    composable(route = "menu") {
                        Menu(navController)
                    }

                    composable(route = "buy_ticket") {
                        BuyTicket(navController)
                    }

                    composable(route = "confirm_ticket") {
                        ConfirmTicket(navController)
                    }

                    composable(route = "ticket") {
                        TicketLayout(navController)
                    }
                }
            }
        }
    }
}