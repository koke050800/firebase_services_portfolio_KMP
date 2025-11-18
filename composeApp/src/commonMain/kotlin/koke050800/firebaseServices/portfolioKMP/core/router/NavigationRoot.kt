import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import koke050800.firebaseServices.portfolioKMP.core.router.Route
import koke050800.firebaseServices.portfolioKMP.features.home.presentation.screen.HomeScreen


@Composable
fun NavigationRoot() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Route.Home
    ) {
        composable<Route.Home> {
            HomeScreen()
        }
//        composable<Route.MemeEditor> {
//            val templateId = it.toRoute<Route.MemeEditor>().templateId
//            val template = remember(templateId) {
//                memeTemplates.first { it.id == templateId }
//            }
//            MemeEditorRoot(
//                template = template,
//                onGoBack = {
//                    navController.navigateUp()
//                }
//            )
//        }
    }
}