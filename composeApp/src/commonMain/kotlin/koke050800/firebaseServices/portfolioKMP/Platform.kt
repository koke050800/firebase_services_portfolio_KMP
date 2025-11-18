package koke050800.firebaseServices.portfolioKMP

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform