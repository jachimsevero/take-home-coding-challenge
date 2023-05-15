package com.circlemove.sample.vm

import androidx.lifecycle.ViewModel
import com.circlemove.sample.repo.SampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnePunchManViewModel @Inject constructor(
    repository: SampleRepository,
) : ViewModel() {
    val modelFlow = repository.modelFlow
}