package koke050800.firebaseServices.portfolioKMP.core.utils

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val currentPlatform: CurrentPlatform = CurrentPlatform.IOS
}

actual fun getPlatform(): Platform = IOSPlatform()