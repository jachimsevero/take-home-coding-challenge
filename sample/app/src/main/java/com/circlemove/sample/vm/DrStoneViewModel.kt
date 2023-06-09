package com.circlemove.sample.vm

import androidx.lifecycle.ViewModel
import com.circlemove.sample.repo.SampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DrStoneViewModel @Inject constructor(
    private val repository: SampleRepository,
) : ViewModel() {
    val modelFlow = repository.modelFlow

    fun setBoardAt(boardAt: Int) = repository.setBoardAt(boardAt)

    fun setAlightAt(alightAt: Int) = repository.setAlightAt(alightAt)
}