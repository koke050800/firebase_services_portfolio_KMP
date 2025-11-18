package com.koke050800.firebase_portfolio_kmp.core.utils

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val currentPlatform: CurrentPlatform = CurrentPlatform.IOS
}

actual fun getPlatform(): Platform = IOSPlatform()