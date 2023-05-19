package com.circlemove.sample.presentation.ui.buyticket

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.circlemove.sample.R
import com.circlemove.sample.presentation.ScreenList
import com.circlemove.sample.presentation.components.*
import com.circlemove.sample.theme.CoGray
import com.google.android.material.dialog.MaterialAlertDialogBuilder

@Composable
fun BuyTicketScreen(navController: NavHostController) {
    val context = LocalContext.current
    val boardText = stringResource(id = R.string.label_board)
    val alightText = stringResource(id = R.string.label_alight)

    val viewModel: BuyTicketViewModel = hiltViewModel()
    val model by viewModel.modelFlow.collectAsState()

    Scaffold(topBar = {
        AppBar(title = stringResource(id = R.string.title_buy), onBackPressed = {
            navController.popBackStack()
        })
    }, content = {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(12.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
            ) {
                CustomText(text = boardText, CoGray)

                CustomTextFields(
                    value = model.boardAtName,
                    readOnly = true,
                    onEditClick = {
                        MaterialAlertDialogBuilder(context)
                            .setTitle(boardText)
                            .setSingleChoiceItems(
                                model.busStops.toTypedArray(),
                                model.boardAt
                            ) { dialog, which ->
                                viewModel.setBoardAt(boardAt = which)
                                dialog.dismiss()
                            }
                            .show()
                    }
                )

                CustomText(text = alightText, CoGray)

                CustomTextFields(
                    value = model.alightAtName,
                    readOnly = true,
                    onEditClick = {
                        MaterialAlertDialogBuilder(context)
                            .setTitle(boardText)
                            .setSingleChoiceItems(
                                model.busStops.toTypedArray(),
                                model.alightAt
                            ) { dialog, which ->
                                viewModel.setAlightAt(alightAt = which)
                                dialog.dismiss()
                            }
                            .show()
                    }
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                CustomButton(
                    onClick = {
                        if (model.alightAt == model.boardAt) {
                            viewModel.showErrorDialog()
                        } else {
                            navController.navigate(route = ScreenList.TicketConfirmationScreen.route)
                        }
                    },
                    text = stringResource(id = R.string.label_proceed)
                )
            }
        }
    })

    CustomDialog(
        showDialog = viewModel.showDialog,
        onDismiss = { viewModel.onDismissDialog() },
        title = stringResource(id = R.string.dialog_dest_title),
        message = stringResource(id = R.string.dialog_dest_text)
    )
}