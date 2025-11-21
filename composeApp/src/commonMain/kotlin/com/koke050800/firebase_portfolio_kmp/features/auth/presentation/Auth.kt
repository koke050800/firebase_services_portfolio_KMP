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
import com.koke050800.firebase_portfolio_kmp.core.theme.FirebasePortfolioKMPTheme
import firebaseportfoliokmp.composeapp.generated.resources.Res
import firebaseportfoliokmp.composeapp.generated.resources.firebase_icon_auth
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AuthRoot(
    viewModel: AuthViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    AuthScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun AuthScreen(
    state: AuthState,
    onAction: (AuthAction) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.firebase_icon_auth),
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
            state = AuthState(),
            onAction = {}
        )
    }
}