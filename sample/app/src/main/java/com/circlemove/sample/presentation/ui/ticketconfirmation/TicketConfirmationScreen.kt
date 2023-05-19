package com.circlemove.sample.presentation.ui.ticketconfirmation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.circlemove.sample.presentation.ui.ticketconfirmation.TicketConfirmationViewModel

@Composable
fun TicketConfirmationScreen() {
    val confirmationViewModel: TicketConfirmationViewModel = hiltViewModel()
    val model by confirmationViewModel.modelFlow.collectAsState()

    Text(text = model.fare.toString())
}