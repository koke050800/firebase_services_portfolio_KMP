package com.koke050800.firebase_portfolio_kmp.features.auth.presentation

data class AuthState(
    val userName : String = "",
    val password : String = "",
    val isPasswordVisible : Boolean = false,
    val isButtonEnabled : Boolean = false,
    val rememberMeNextTime : Boolean = false,
)