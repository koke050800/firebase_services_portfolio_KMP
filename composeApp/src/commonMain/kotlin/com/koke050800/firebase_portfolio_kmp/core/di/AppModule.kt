package com.koke050800.firebase_portfolio_kmp.core.di

import com.koke050800.firebase_portfolio_kmp.features.auth.presentation.AuthViewModel
import com.koke050800.firebase_portfolio_kmp.features.home.presentation.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf (::AuthViewModel)
    viewModelOf(::HomeViewModel)
}