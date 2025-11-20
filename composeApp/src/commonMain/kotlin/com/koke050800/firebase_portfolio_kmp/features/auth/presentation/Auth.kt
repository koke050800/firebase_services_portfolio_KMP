package com.koke050800.firebase_portfolio_kmp.features.auth.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.Image
import com.koke050800.firebase_portfolio_kmp.core.theme.FirebasePortfolioKMPTheme
import com.koke050800.firebase_portfolio_kmp.features.home.presentation.FirebaseIconTemplate
import firebaseportfoliokmp.composeapp.generated.resources.Res
import firebaseportfoliokmp.composeapp.generated.resources.firebase_icon_auth
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AuthRoot(
    firebaseIconTemplate: FirebaseIconTemplate,
    viewModel: AuthViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    AuthScreen(
        firebaseIconTemplate = firebaseIconTemplate,
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun AuthScreen(
    firebaseIconTemplate: FirebaseIconTemplate,
    state: AuthState,
    onAction: (AuthAction) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(firebaseIconTemplate.drawableResource),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(0.65f)
        )
    }

}

@Preview
@Composable
private fun Preview() {
    FirebasePortfolioKMPTheme {
        AuthScreen(
            firebaseIconTemplate = FirebaseIconTemplate(
                id = "firebase_icon_auth",
                drawableResource = Res.drawable.firebase_icon_auth,
                name = "Auth"
            ),
            state = AuthState(),
            onAction = {}
        )
    }
}