package com.koke050800.firebase_portfolio_kmp.core.utils

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val currentPlatform: CurrentPlatform = CurrentPlatform.ANDROID
}

actual fun getPlatform(): Platform = AndroidPlatform()