package com.koke050800.firebase_portfolio_kmp.features.home.data

import firebaseportfoliokmp.composeapp.generated.resources.Res
import firebaseportfoliokmp.composeapp.generated.resources.allDrawableResources
import org.jetbrains.compose.resources.DrawableResource

data class FirebaseIconData(
    val id: String,
    val drawableResource: DrawableResource,
)

val firebaseIconList = Res.allDrawableResources
    .filterKeys { it.startsWith("firebase_icon_") }
    .map { (id, drawable) ->
        FirebaseIconData(
            id = id,
            drawableResource = drawable,
        )
    }

