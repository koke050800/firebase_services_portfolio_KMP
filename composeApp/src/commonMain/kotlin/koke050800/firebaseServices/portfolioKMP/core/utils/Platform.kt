package koke050800.firebaseServices.portfolioKMP.core.utils

enum class CurrentPlatform {
    ANDROID,
    IOS,
}

interface Platform {
    val name: String
    val currentPlatform: CurrentPlatform
}

expect fun getPlatform(): Platform