package com.circlemove.sample.presentation.ui.ticketconfirmation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.circlemove.sample.R
import com.circlemove.sample.presentation.ScreenList
import com.circlemove.sample.presentation.components.*
import com.circlemove.sample.theme.CoDarkBlue
import com.circlemove.sample.theme.CoGray

@Composable
fun TicketConfirmationScreen(navController: NavHostController) {
    val viewModel: TicketConfirmationViewModel = hiltViewModel()
    val model by viewModel.modelFlow.collectAsState()
    val load by viewModel.loadValue.collectAsState()

    Scaffold(topBar = {
        AppBar(title = stringResource(id = R.string.title_confirm), onBackPressed = {
            navController.popBackStack()
        })
    }, content = {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(12.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
            ) {
                CustomText(text = stringResource(id = R.string.label_board), CoGray)

                CustomText(text = model.boardAtName, CoDarkBlue, 36.sp)

                CustomText(
                    text = stringResource(id = R.string.label_alight),
                    color = CoGray,
                    paddingTop = 8.dp
                )

                CustomText(text = model.alightAtName, CoDarkBlue, 36.sp)

                CustomText(
                    text = stringResource(id = R.string.label_fare),
                    color = CoGray,
                    paddingTop = 24.dp
                )

                CustomText(
                    text = stringResource(
                        R.string.value_currency,
                        model.fare
                    ), CoDarkBlue, 36.sp
                )

                Divider(
                    color = CoDarkBlue,
                    thickness = 2.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                )

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    CustomText(
                        text = stringResource(R.string.label_vat),
                        color = Color.Red,
                        textSize = 16.sp,
                    )
                }
            }

            BottomButton(text = stringResource(id = R.string.value_pay, model.fare)) {
                if (model.fare > load) {
                    viewModel.showErrorDialog()
                } else {
                    viewModel.updateLoad()
                    navController.navigate(route = ScreenList.ResultsScreen.route) {
                        popUpTo(ScreenList.MenuScreen.route) {
                            inclusive = false
                        }
                    }
                }
            }
        }
    })

    CustomDialog(
        showDialog = viewModel.showDialog,
        onDismiss = { viewModel.onDismissDialog() },
        title = stringResource(id = R.string.dialog_dest_title),
        message = stringResource(id = R.string.dialog_balance_text)
    )
}