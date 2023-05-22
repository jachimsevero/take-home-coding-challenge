package com.circlemove.sample.vm

import androidx.lifecycle.ViewModel
import com.circlemove.sample.repo.StationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConfirmTicketViewModel @Inject constructor(
    private val repository: StationRepository,
) : ViewModel() {
    val stationModelFlow = repository.stationModelFlow
    val userModelFlow = repository.userModelFlow

    fun buyTicket(price: Double) = repository.buyTicket(price)
}