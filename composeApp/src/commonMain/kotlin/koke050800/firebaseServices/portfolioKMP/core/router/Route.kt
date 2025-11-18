package koke050800.firebaseServices.portfolioKMP.core.router

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object Home: Route

//    @Serializable
//    data class MemeEditor(
//        val templateId: String
//    ): Route
}