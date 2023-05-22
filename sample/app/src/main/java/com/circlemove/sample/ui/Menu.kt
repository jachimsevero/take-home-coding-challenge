package com.circlemove.sample.ui


import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.circlemove.sample.R
import com.circlemove.sample.vm.BuyTicketViewModel
import com.circlemove.sample.vm.MenuViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

@Composable
fun Menu(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val viewModel: MenuViewModel = hiltViewModel()
        val userModel by viewModel.userModelFlow.collectAsState()
        val stationModel by viewModel.stationModelFlow.collectAsState()

        val context = LocalContext.current
        val comingSoon = stringResource(R.string.coming_soon)
        val message = stringResource(R.string.coming_soon_message)
        val ok = stringResource(R.string.ok)

        Text(
            text = String.format("%.2f", userModel.balance),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                MaterialAlertDialogBuilder(context)
                    .setTitle(comingSoon)
                    .setMessage(message)
                    .setPositiveButton(ok, null)
                    .show()
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = "BUY LOAD",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            onClick = {
                navController.navigate(route = "buy_ticket")
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = "BUY TICKET",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            onClick = {
                MaterialAlertDialogBuilder(context)
                    .setTitle(comingSoon)
                    .setMessage(message)
                    .setPositiveButton(ok, null)
                    .show()
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = "SEND MONEY",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}