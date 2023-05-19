package com.circlemove.sample.presentation.ui.buyticket

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.circlemove.sample.R
import com.circlemove.sample.presentation.ScreenList
import com.circlemove.sample.presentation.components.CustomButton
import com.circlemove.sample.presentation.components.AppBar
import com.circlemove.sample.presentation.components.CustomText
import com.circlemove.sample.presentation.components.CustomTextFields
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
                                viewModel.setBoardAt(boardAt = which)
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
                        navController.navigate(route = ScreenList.TicketConfirmationScreen.route)
                    },
                    text = stringResource(id = R.string.label_proceed)
                )
            }
        }
    })
}