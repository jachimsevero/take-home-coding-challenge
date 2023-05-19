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
                "Valenzuela",
                "Marilao",
                "Bocaue",
                "Balagtas",
                "Guiguinto",
                "Plaridel",
                "Apalit",
                "San Fernando",
                "Mexico"
            ),

            boardAt = 0,
            alightAt = 8,

            fareMatrix = createFareMatrix()
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

    private fun createFareMatrix(): Map<Pair<Int, Int>, Float> {
        val fareMatrix = mutableMapOf<Pair<Int, Int>, Float>()

        for (row in 0..8) {
            for (column in 0..8) {
                val fare = calculateFare(row, column)
                fareMatrix[row to column] = fare
            }
        }

        return fareMatrix
    }

    private fun calculateFare(row: Int, column: Int): Float {
        return when {
            row == column -> 0f
            row < column -> (column - row).toFloat() * 6f * 3.5f
            else -> (row - column).toFloat() * 6f * 3.5f
        }
    }
}