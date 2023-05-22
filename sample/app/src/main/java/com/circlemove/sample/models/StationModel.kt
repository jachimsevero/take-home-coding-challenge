package com.circlemove.sample.models

import kotlin.math.abs

data class StationModel(
    val price: Double,
    val busStops: ArrayList<BusStopModel>,
) {

    fun getName(position: Int): String {
        return busStops[position].name
    }

    fun getDistance(position: Int): Double {
        return busStops[position].distance
    }

    fun getTotal(board: Int, alight: Int): Double {
        return price * abs(busStops[board].distance - busStops[alight].distance)
    }
}
