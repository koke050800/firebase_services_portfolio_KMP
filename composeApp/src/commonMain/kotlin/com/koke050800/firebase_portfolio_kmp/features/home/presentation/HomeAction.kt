package com.koke050800.firebase_portfolio_kmp.features.home.presentation

import com.koke050800.firebase_portfolio_kmp.core.router.Route

sealed interface HomeAction {
    data class OnCardClick(val route: Route) : HomeAction
}
