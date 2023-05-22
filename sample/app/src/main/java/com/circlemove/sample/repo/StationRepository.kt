package com.circlemove.sample.repo

import com.circlemove.sample.models.StationModel
import com.circlemove.sample.models.UserModel
import kotlinx.coroutines.flow.StateFlow

interface StationRepository {
    val stationModelFlow: StateFlow<StationModel>
    val userModelFlow: StateFlow<UserModel>

    fun setBoardAt(boardAt: Int)

    fun setAlightAt(alightAt: Int)

    fun buyTicket(price: Double)
}