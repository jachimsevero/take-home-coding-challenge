package com.circlemove.sample.domain.repo

import com.circlemove.sample.data.models.SampleModel
import kotlinx.coroutines.flow.StateFlow

interface SampleRepository {
    val loadValue: StateFlow<Float>
    val modelFlow: StateFlow<SampleModel>

    fun setBoardAt(boardAt: Int)

    fun setAlightAt(alightAt: Int)
}