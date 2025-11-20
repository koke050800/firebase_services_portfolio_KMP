package com.koke050800.firebase_portfolio_kmp.features.auth.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.koke050800.firebase_portfolio_kmp.core.theme.FirebasePortfolioKMPTheme

@Composable
fun AuthRoot(
    viewModel: AuthViewModel = viewModel()
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