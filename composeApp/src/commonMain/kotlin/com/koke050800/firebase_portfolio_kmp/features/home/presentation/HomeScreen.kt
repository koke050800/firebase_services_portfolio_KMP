package com.koke050800.firebase_portfolio_kmp.features.home.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import firebase_portfolio_kmp.composeapp.generated.resources.Res
import firebase_portfolio_kmp.composeapp.generated.resources.title_home_screen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
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
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(minSize = 150.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalItemSpacing = 8.dp,
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.padding(innerPadding),
        ) {
            items(
                items = firebaseIconTemplates, key = { it.id }) { firebaseIconTemplate ->
                Card(
                    onClick = {
                        println("Clicked on ${firebaseIconTemplate.id}")
                    },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                ) {
                    Image(
                        painter = painterResource(firebaseIconTemplate.drawableResource),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}
