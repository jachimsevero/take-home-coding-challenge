package com.circlemove.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.circlemove.sample.ui.DrStone
import com.circlemove.sample.ui.MyFavoriteAnime
import com.circlemove.sample.ui.OnePunchMan
import com.circlemove.sample.ui.Splash
import com.circlemove.sample.theme.Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Theme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = "splash") {
                    composable(route = "splash") {
                        Splash(navController)
                    }

                    composable(route = "my_favorite_anime") {
                        MyFavoriteAnime(navController)
                    }

                    composable(route = "dr_stone") {
                        DrStone(navController)
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