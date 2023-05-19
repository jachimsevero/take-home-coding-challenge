package com.circlemove.sample.presentation.ui.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.circlemove.sample.R
import com.circlemove.sample.presentation.ScreenList
import com.circlemove.sample.presentation.ui.components.CustomButton
import com.circlemove.sample.presentation.ui.components.CustomDialog
import com.circlemove.sample.presentation.vm.OnePunchManViewModel
import com.circlemove.sample.theme.CoDarkBlue

@Composable
fun MenuScreen(navController: NavHostController) {
    val viewModel: OnePunchManViewModel = hiltViewModel()
    val load by viewModel.loadValue.collectAsState()


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var showDialog by remember { mutableStateOf(false) }

        Image(
            painter = painterResource(R.drawable.app_logo),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.Center)
            ) {
                Text(
                    text = stringResource(id = R.string.label_currency),
                    color = CoDarkBlue,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Text(
                    text = stringResource(id = R.string.value_currency, load),
                    color = CoDarkBlue,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }

        CustomButton(
            onClick = {
                showDialog = true
            },
            text = stringResource(id = R.string.label_buy_load)
        )

        CustomButton(
            onClick = {
                navController.navigate(route = ScreenList.BuyTicketScreen.route)
            },
            text = stringResource(id = R.string.label_buy_ticket)
        )

        CustomButton(
            onClick = {
                showDialog = true
            },
            text = stringResource(id = R.string.label_send_money)
        )

        CustomDialog(
            showDialog = showDialog,
            onDismiss = { showDialog = false }
        )
    }
}