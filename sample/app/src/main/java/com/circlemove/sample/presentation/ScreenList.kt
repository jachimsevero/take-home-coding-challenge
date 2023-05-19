package com.circlemove.sample.presentation

sealed class ScreenList(val route: String) {
    object SplashScreen: ScreenList("splash")
    object MenuScreen: ScreenList("menu_screen")
    object BuyTicketScreen: ScreenList("buy_ticket")
    object ConfirmTicketScreen : ScreenList("confirm_ticket")
    object ConfirmationScreen: ScreenList("confirmation")
}