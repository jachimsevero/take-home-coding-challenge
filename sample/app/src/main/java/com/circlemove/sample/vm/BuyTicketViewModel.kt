package com.circlemove.sample.vm

import androidx.lifecycle.ViewModel
import com.circlemove.sample.repo.StationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BuyTicketViewModel @Inject constructor(
    private val repository: StationRepository,
) : ViewModel() {
    val stationModelFlow = repository.stationModelFlow
    val userModelFlow = repository.userModelFlow

    fun setBoardAt(boardAt: Int) = repository.setBoardAt(boardAt)

    fun setAlightAt(alightAt: Int) = repository.setAlightAt(alightAt)
}