package com.circlemove.sample.repo

import com.circlemove.sample.models.SampleModel
import kotlinx.coroutines.flow.StateFlow

interface SampleRepository {
    val modelFlow: StateFlow<SampleModel>

    fun setBoardAt(boardAt: Int)

    fun setAlightAt(alightAt: Int)
}