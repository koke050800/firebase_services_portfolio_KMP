package com.koke050800.firebase_portfolio_kmp

import android.app.Application
import com.koke050800.firebase_portfolio_kmp.core.di.initKoin
import org.koin.android.ext.koin.androidContext

class FirebasePortfolioKMPApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@FirebasePortfolioKMPApplication)

        }
    }
}