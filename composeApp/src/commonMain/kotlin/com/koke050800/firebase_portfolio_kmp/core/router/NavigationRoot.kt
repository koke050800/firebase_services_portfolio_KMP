import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.koke050800.firebase_portfolio_kmp.core.router.Route
import com.koke050800.firebase_portfolio_kmp.features.home.presentation.HomeScreen


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