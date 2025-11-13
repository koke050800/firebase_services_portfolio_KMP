package com.example.firebase_services_portfolio_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform