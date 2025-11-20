package com.koke050800.firebase_portfolio_kmp.features.home.presentation

import firebaseportfoliokmp.composeapp.generated.resources.Res
import firebaseportfoliokmp.composeapp.generated.resources.allDrawableResources
import org.jetbrains.compose.resources.DrawableResource

data class FirebaseIconTemplate(
    val id: String,
    val drawableResource: DrawableResource,
    val name: String,
)

val firebaseIconTemplates = Res.allDrawableResources.filterKeys {
    it.startsWith("firebase_icon_")
}.map {
    val rawName = it.key.substringAfter("firebase_icon_")
    val name = rawName.split('_').joinToString(" ") { word ->
        word.replaceFirstChar { char ->
            if (char.isLowerCase()) char.titlecase() else char.toString()
        }
    }
    FirebaseIconTemplate(
        id = it.key,
        drawableResource = it.value,
        name = name,
    )
}
