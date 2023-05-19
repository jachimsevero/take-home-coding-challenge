package com.circlemove.sample.presentation.ui.ticketconfirmation

import androidx.lifecycle.ViewModel
import com.circlemove.sample.domain.repo.SampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TicketConfirmationViewModel @Inject constructor(
    repository: SampleRepository,
) : ViewModel() {
    val loadValue = repository.loadValue
    val modelFlow = repository.modelFlow
}