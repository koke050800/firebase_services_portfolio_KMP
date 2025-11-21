package com.koke050800.firebase_portfolio_kmp.core.router

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object Home : Route

    @Serializable
    data object AppCheck : Route

    @Serializable
    data object Auth : Route

    @Serializable
    data object CloudMessaging : Route

    @Serializable
    data object Database : Route

    @Serializable
    data object Storage : Route

}
