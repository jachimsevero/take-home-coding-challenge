package com.circlemove.sample.presentation.ui.menu

import com.circlemove.sample.domain.repo.SampleRepository
import com.circlemove.sample.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val repository: SampleRepository,
) : BaseViewModel() {
    private val _loadValue = repository.loadValue
    val loadValue: StateFlow<Float> = _loadValue
}