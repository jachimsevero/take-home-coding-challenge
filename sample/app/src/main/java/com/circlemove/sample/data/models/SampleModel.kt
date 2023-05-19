package com.circlemove.sample.data.models

data class SampleModel(
    val busStops: List<String>,
    val boardAt: Int,
    val alightAt: Int,
    val fareMatrix: Map<Pair<Int, Int>, Float>,
) {
    val boardAtName: String
        get() = busStops[boardAt]

    val alightAtName: String
        get() = busStops[alightAt]

    val fare: Float
        get() = requireNotNull(
            fareMatrix[boardAt to alightAt]
        )
}