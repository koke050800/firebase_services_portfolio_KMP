package com.koke050800.firebase_portfolio_kmp.core.router

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object Home : Route

    @Serializable
    data class Auth(
        val firebaseIconTemplateId: String
    ) : Route
}