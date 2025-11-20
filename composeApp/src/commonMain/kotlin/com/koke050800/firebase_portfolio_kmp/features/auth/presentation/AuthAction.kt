package com.koke050800.firebase_portfolio_kmp.features.auth.presentation

sealed interface AuthAction {
    data class OnChangeUserName(val userName: String) : AuthAction
    data class OnChangePassword(val password: String) : AuthAction
    data object OnChangePasswordVisibility : AuthAction
    data object OnChangeRememberMeNextTime : AuthAction
    data class OnLogin(val userName: String, val password: String) : AuthAction
}

