package com.koke050800.firebase_portfolio_kmp.features.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.koke050800.firebase_portfolio_kmp.core.router.Route
import com.koke050800.firebase_portfolio_kmp.core.theme.FirebasePortfolioKMPTheme
import com.koke050800.firebase_portfolio_kmp.features.home.data.firebaseIconList
import firebaseportfoliokmp.composeapp.generated.resources.Res
import firebaseportfoliokmp.composeapp.generated.resources.title_home_screen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeRoot(
    viewModel: HomeViewModel = koinViewModel(),
    onNavigate: (Route) -> Unit,
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeEffect.Navigate -> onNavigate(effect.route)
            }
        }
    }

    HomeScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit,
) {


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(Res.string.title_home_screen)
                    )
                })
        },
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 120.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.padding(innerPadding),
        ) {
            items(
                items = state.templates, key = { it.id }) { firebaseIconData ->
                Card(
                    modifier = Modifier.aspectRatio(0.9f),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    ),
                    onClick = {
                        val route = firebaseIconRoutes[firebaseIconData.id] ?: Route.Home
                        onAction(HomeAction.OnCardClick(route))
                    },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Image(
                                painter = painterResource(firebaseIconData.drawableResource),
                                contentDescription = null,
                                modifier = Modifier.fillMaxWidth(0.65f)
                            )

                            Text(
                                text = firebaseIconNames[firebaseIconData.id] ?: "Unknown Name",
                                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(horizontal = 4.dp)
                                    .padding(bottom = 8.dp),
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 2,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    FirebasePortfolioKMPTheme {
        HomeScreen(
            state = HomeState(templates = firebaseIconList),
            onAction = {}
        )
    }
}
