package com.circlemove.sample.repo

import com.circlemove.sample.models.BusStopModel
import com.circlemove.sample.models.StationModel
import com.circlemove.sample.models.UserModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class StationRepositoryImpl : StationRepository {
    override val stationModelFlow = MutableStateFlow(
        StationModel(
            price = 5.5,
            busStops = arrayListOf(
                BusStopModel("North Avenue Station", 6.0),
                BusStopModel("Quezon Avenue", 9.0),
                BusStopModel("GMA – Kamuning", 14.4),
                BusStopModel("Araneta Center – Cubao", 21.0),
                BusStopModel("Santolan – Annapolis", 32.7),
                BusStopModel("Ortigas", 38.0),
                BusStopModel("Shaw Boulevard", 43.3),
                BusStopModel("Boni", 56.0),
                BusStopModel("Guadalupe", 72.5),
                BusStopModel("Buendia Station", 80.3),
                BusStopModel("Ayala Stations", 92.0),
                BusStopModel("Magallanes", 98.5),
                BusStopModel("Taft Avenue Station", 100.1),
            )
        )
    )

    override val userModelFlow =  MutableStateFlow(
        UserModel(
            balance = 3470.15,
            boardAt = 0,
            alightAt = stationModelFlow.value.busStops.size - 1
        )
    )

    override fun setBoardAt(boardAt: Int) {
        val model = userModelFlow.value

        userModelFlow.value = UserModel(
            balance = model.balance,
            boardAt = boardAt,
            alightAt = model.alightAt
        )
    }

    override fun setAlightAt(alightAt: Int) {
        val model = userModelFlow.value

        userModelFlow.value = UserModel(
            balance = model.balance,
            boardAt = model.boardAt,
            alightAt = alightAt
        )
    }

    override fun buyTicket(price: Double) {
        val model = userModelFlow.value

        userModelFlow.value = UserModel(
            balance = model.balance - price,
            boardAt = model.boardAt,
            alightAt = model.alightAt
        )
    }
}