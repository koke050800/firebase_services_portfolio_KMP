package com.koke050800.firebase_portfolio_kmp.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koke050800.firebase_portfolio_kmp.core.router.Route
import com.koke050800.firebase_portfolio_kmp.features.home.data.firebaseIconList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface HomeEffect {
    data class Navigate(val route: Route) : HomeEffect
}

class HomeViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(HomeState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                _state.update { it.copy(templates = firebaseIconList) }
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = HomeState()
        )

    private val _effect = MutableSharedFlow<HomeEffect>()
    val effect = _effect.asSharedFlow()

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.OnCardClick -> {
                viewModelScope.launch {
                    _effect.emit(HomeEffect.Navigate(action.route))
                }
            }
        }
    }

}
