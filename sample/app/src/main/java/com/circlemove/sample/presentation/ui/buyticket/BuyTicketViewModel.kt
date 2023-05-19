package com.circlemove.sample.presentation.ui.buyticket

import com.circlemove.sample.domain.repo.SampleRepository
import com.circlemove.sample.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BuyTicketViewModel @Inject constructor(
    private val repository: SampleRepository,
) : BaseViewModel() {
    private val _modelFlow = repository.modelFlow
    val modelFlow = _modelFlow

    fun setBoardAt(boardAt: Int) = repository.setBoardAt(boardAt)

    fun setAlightAt(alightAt: Int) = repository.setAlightAt(alightAt)
}