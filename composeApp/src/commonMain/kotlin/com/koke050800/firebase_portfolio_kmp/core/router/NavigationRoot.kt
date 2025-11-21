package com.koke050800.firebase_portfolio_kmp.core.router

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.koke050800.firebase_portfolio_kmp.features.auth.presentation.AuthRoot
import com.koke050800.firebase_portfolio_kmp.features.home.presentation.HomeRoot

@Composable
fun NavigationRoot() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.Home) {
        composable<Route.Home> {
            HomeRoot(
                onNavigate = { navController.navigate(it) }
            )
        }
        composable<Route.Auth> { AuthRoot() }
        
//        composable<Route.Auth> { navBackStackEntry ->
//            val firebaseIconTemplateId =
//                navBackStackEntry.toRoute<Route.Auth>().firebaseIconTemplateId
//            val template = remember(firebaseIconTemplateId) {
//                firebaseIconTemplates.first { it.id == firebaseIconTemplateId }
//            }
//            AuthRoot(firebaseIconTemplate = template)
//        }

    }


}

