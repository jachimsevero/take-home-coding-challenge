package com.circlemove.sample.presentation

sealed class ScreenList(val route: String) {
    object MenuScreen: ScreenList("menu_screen")
    object BuyTicketScreen: ScreenList("buy_ticket")
    object TicketConfirmationScreen : ScreenList("confirm_ticket")
    object ResultsScreen: ScreenList("results")
}