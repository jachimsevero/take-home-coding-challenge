package com.circlemove.sample.data.repo

import com.circlemove.sample.data.models.SampleModel
import com.circlemove.sample.domain.repo.SampleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class SampleRepositoryImpl : SampleRepository {
    override val loadValue: StateFlow<Float>
        get() = MutableStateFlow(2000f)

    override val modelFlow = MutableStateFlow(
        SampleModel(
            busStops = listOf(
                "bus stop 1",
                "bus stop 2",
                "bus stop 3",
            ),

            boardAt = 0,
            alightAt = 2,

            fareMatrix = mapOf(
                (0 to 0) to "0.00",
                (0 to 1) to "1.00",
                (0 to 2) to "2.00",
                (1 to 0) to "1.00",
                (1 to 1) to "0.00",
                (1 to 2) to "1.00",
                (2 to 0) to "2.00",
                (2 to 1) to "1.00",
                (2 to 2) to "0.00",
            )
        )
    )

    override fun setBoardAt(boardAt: Int) {
        val model = modelFlow.value

        modelFlow.value = SampleModel(
            busStops = model.busStops,
            boardAt = boardAt,
            alightAt = model.alightAt,
            fareMatrix = model.fareMatrix
        )
    }

    override fun setAlightAt(alightAt: Int) {
        val model = modelFlow.value

        modelFlow.value = SampleModel(
            busStops = model.busStops,
            boardAt = model.boardAt,
            alightAt = alightAt,
            fareMatrix = model.fareMatrix
        )
    }
}