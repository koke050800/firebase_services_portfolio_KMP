import Foundation
import UIKit
import composeApp

class AppDelegate: NSObject, UIApplicationDelegate {

    func application(_application: UIApplication,
                     didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]? = nil) -> Bool {

        print("AppDelegate: didFinishLaunchingWithOptions - Calling KMP init.")

        FirebaseHelper.shared.doInit()

        return true
    }
}