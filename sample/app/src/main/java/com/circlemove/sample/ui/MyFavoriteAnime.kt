package com.circlemove.sample.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.circlemove.sample.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

@Composable
fun MyFavoriteAnime(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val context = LocalContext.current
        val title = stringResource(R.string.title)
        val message = stringResource(R.string.message)
        val ok = stringResource(R.string.ok)

        // Some basic dialog
        Button(
            onClick = {
                MaterialAlertDialogBuilder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(ok, null)
                    .show()
            }
        ) {
            Text(text = "one piece")
        }

        // This button leads to somewhere
        Button(
            onClick = {
                navController.navigate(route = "dr_stone")
            }
        ) {
            Text(text = "dr. stone")
        }

        Button(
            onClick = {
                TODO()
            }
        ) {
            Text(text = "code geass")
        }
    }
}