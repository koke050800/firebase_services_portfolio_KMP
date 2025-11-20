package com.koke050800.firebase_portfolio_kmp.features.home.presentation

import firebase_portfolio_kmp.composeapp.generated.resources.Res
import firebase_portfolio_kmp.composeapp.generated.resources.allDrawableResources
import org.jetbrains.compose.resources.DrawableResource

data class FirebaseIconTemplate(
    val id: String, val drawableResource: DrawableResource
)

val firebaseIconTemplates = Res.allDrawableResources.filterKeys {
    it.startsWith("firebase_icon_")
}.map { FirebaseIconTemplate(it.key, it.value) }


