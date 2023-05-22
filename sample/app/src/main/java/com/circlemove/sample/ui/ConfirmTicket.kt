package com.circlemove.sample.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.circlemove.sample.vm.ConfirmTicketViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

@Composable
fun ConfirmTicket(navController: NavHostController) {
    val viewModel: ConfirmTicketViewModel = hiltViewModel()
    val stationModel by viewModel.stationModelFlow.collectAsState()
    val userModel by viewModel.userModelFlow.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "CONFIRM TICKET") },
                navigationIcon = if (navController.previousBackStackEntry != null) {
                    {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                } else {
                    null
                }

            )
        },
        content = {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = stationModel.getName(userModel.boardAt),
                        onValueChange = {},
                        readOnly = true,
                        label = {
                            Text(
                                text = "Board at",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),

                        colors = TextFieldDefaults.textFieldColors(
                            disabledTextColor = Color.Transparent,
                            backgroundColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                    )

                    TextField(
                        value = stationModel.getName(userModel.alightAt),
                        onValueChange = {},
                        readOnly = true,
                        label = {
                            Text(
                                text = "Alight at",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),

                        colors = TextFieldDefaults.textFieldColors(
                            disabledTextColor = Color.Transparent,
                            backgroundColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),

                    )

                    OutlinedTextField(
                        value = String.format("PHP %.2f", stationModel.getTotal(userModel.boardAt, userModel.alightAt)),
                        onValueChange = {},
                        readOnly = true,
                        label = {
                            Text(
                                text = "FAIR",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                    )
                }

                Button(
                    onClick = {
                        viewModel.buyTicket(stationModel.getTotal(userModel.boardAt, userModel.alightAt))
                        navController.navigate(route = "ticket")
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(text = String.format("PAY %.2f", stationModel.getTotal(userModel.boardAt, userModel.alightAt)), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }


            }

        }
    )
}