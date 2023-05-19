package com.circlemove.sample.data.models

data class SampleModel(
    val busStops: List<String>,
    val boardAt: Int,
    val alightAt: Int,
    val fareMatrix: Map<Pair<Int, Int>, String>,
) {
    val boardAtName: String
        get() = busStops[boardAt]

    val alightAtName: String
        get() = busStops[alightAt]

    val fare: String
        get() = requireNotNull(
            fareMatrix[boardAt to alightAt]
        )
}