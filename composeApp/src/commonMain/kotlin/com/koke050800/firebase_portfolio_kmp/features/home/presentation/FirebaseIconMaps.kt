package com.koke050800.firebase_portfolio_kmp.features.home.presentation

import com.koke050800.firebase_portfolio_kmp.core.router.Route

val firebaseIconNames: Map<String, String> = mapOf(
    "firebase_icon_auth" to "Firebase Auth",
    "firebase_icon_firestore" to "Cloud Firestore",
    "firebase_icon_storage" to "Cloud Storage",
    "firebase_icon_functions" to "Cloud Functions",
    "firebase_icon_crashlytics" to "Crashlytics",
    "firebase_icon_analytics" to "Analytics",
)

val firebaseIconRoutes: Map<String, Route> = mapOf(
    "firebase_icon_app_check" to Route.AppCheck,
    "firebase_icon_auth" to Route.Auth,
    "firebase_icon_database" to Route.Database,
    "firebase_icon_storage" to Route.Storage,
    "firebase_icon_messaging" to Route.CloudMessaging,
)