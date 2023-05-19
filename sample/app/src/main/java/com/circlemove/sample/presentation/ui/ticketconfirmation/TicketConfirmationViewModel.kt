package com.circlemove.sample.presentation.ui.ticketconfirmation

import com.circlemove.sample.data.models.SampleModel
import com.circlemove.sample.domain.repo.SampleRepository
import com.circlemove.sample.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class TicketConfirmationViewModel @Inject constructor(
    private val repository: SampleRepository,
) : BaseViewModel() {
    private val _modelFlow = repository.modelFlow
    val modelFlow: StateFlow<SampleModel> = _modelFlow

    private val _loadValue = repository.loadValue
    val loadValue: StateFlow<Float> = _loadValue

    fun updateLoad() {
        repository.setLoad(_loadValue.value - _modelFlow.value.fare)
    }
}