package com.koke050800.firebase_portfolio_kmp.core.router

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.koke050800.firebase_portfolio_kmp.features.auth.presentation.AuthRoot
import com.koke050800.firebase_portfolio_kmp.features.home.presentation.HomeScreen
import com.koke050800.firebase_portfolio_kmp.features.home.presentation.firebaseIconTemplates


@Composable
fun NavigationRoot() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Route.Home
    ) {
        composable<Route.Home> {
            HomeScreen()
        }
        composable<Route.Auth> { navBackStackEntry ->
            val firebaseIconTemplateId =
                navBackStackEntry.toRoute<Route.Auth>().firebaseIconTemplateId
            val template = remember(firebaseIconTemplateId) {
                firebaseIconTemplates.first { it.id == firebaseIconTemplateId }
            }
            AuthRoot(firebaseIconTemplate = template)
        }
    }
}