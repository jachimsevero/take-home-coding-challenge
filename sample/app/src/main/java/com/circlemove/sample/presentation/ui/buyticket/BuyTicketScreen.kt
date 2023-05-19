package com.circlemove.sample.presentation.ui.buyticket

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.circlemove.sample.R
import com.circlemove.sample.presentation.vm.DrStoneViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

@Composable
fun BuyTicketScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val context = LocalContext.current
        val title = stringResource(id = R.string.dialog_soon_title)

        val viewModel: DrStoneViewModel = hiltViewModel()
        val model by viewModel.modelFlow.collectAsState()

        TextField(
            value = model.boardAtName,
            onValueChange = {},
            readOnly = true,

            trailingIcon = {
                IconButton(
                    onClick = {
                        MaterialAlertDialogBuilder(context)
                            .setTitle(title)
                            .setSingleChoiceItems(
                                model.busStops.toTypedArray(),
                                model.boardAt
                            ) { dialog, which ->
                                viewModel.setBoardAt(boardAt = which)
                                dialog.dismiss()
                            }
                            .show()
                    }
                ) {
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = null
                    )
                }
            }
        )

        TextField(
            value = model.alightAtName,
            onValueChange = {},
            readOnly = true,

            trailingIcon = {
                IconButton(
                    onClick = {
                        MaterialAlertDialogBuilder(context)
                            .setTitle(title)
                            .setSingleChoiceItems(
                                model.busStops.toTypedArray(),
                                model.alightAt
                            ) { dialog, which ->
                                viewModel.setAlightAt(alightAt = which)
                                dialog.dismiss()
                            }
                            .show()
                    }
                ) {
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = null
                    )
                }
            }
        )

        Button(
            onClick = {
                navController.navigate(route = "one_punch_man")
            }
        ) {
            Text(text = "continue")
        }
    }
}