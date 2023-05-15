package com.circlemove.sample.repo

import com.circlemove.sample.models.SampleModel
import kotlinx.coroutines.flow.MutableStateFlow

internal class SampleRepositoryImpl : SampleRepository {
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