package com.koke050800.firebase_portfolio_kmp

import cocoapods.FirebaseCore.FIRApp
import kotlinx.cinterop.ExperimentalForeignApi

object FirebaseHelper {
    @OptIn(ExperimentalForeignApi::class)
    fun doInit() {
        println("KMP Initializer: Starting setup...")
        FIRApp.configure()
        println("KMP Initializer: Firebase Configured.")
    }
}