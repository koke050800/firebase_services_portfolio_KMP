package com.koke050800.firebase_portfolio_kmp.core.utils

enum class CurrentPlatform {
    ANDROID,
    IOS,
}

interface Platform {
    val name: String
    val currentPlatform: CurrentPlatform
}

expect fun getPlatform(): Platform