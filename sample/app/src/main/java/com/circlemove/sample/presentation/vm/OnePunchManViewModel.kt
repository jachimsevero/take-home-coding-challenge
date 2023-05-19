package com.circlemove.sample.presentation.vm

import androidx.lifecycle.ViewModel
import com.circlemove.sample.domain.repo.SampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnePunchManViewModel @Inject constructor(
    repository: SampleRepository,
) : ViewModel() {
    val loadValue = repository.loadValue
    val modelFlow = repository.modelFlow
}