package com.koke050800.firebase_portfolio_kmp.features.home.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    // Lista de iconos para mostrar en la cuadrícula
    val firebaseServicesIcons: List<ImageVector> = listOf(
        Icons.Filled.LocalFireDepartment,
        Icons.Filled.AccountCircle,
        Icons.Filled.Storage,
        Icons.Filled.Cloud,
        Icons.Filled.DataObject,
        Icons.Filled.Notifications,
        Icons.Filled.Analytics,
        Icons.Filled.Code,
        Icons.Filled.Build,
        Icons.Filled.Settings,
        Icons.AutoMirrored.Filled.Login,
        Icons.Filled.Add,
        Icons.Filled.Favorite,
        Icons.Filled.Home
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Servicios de Firebase") })
        },
    ) { innerPadding ->
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(minSize = 120.dp), // Reducido para mejor visualización
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp), // Espacio horizontal entre tarjetas
            verticalItemSpacing = 8.dp // Espacio vertical entre tarjetas
        ) {
            items(
                items = firebaseServicesIcons,
                key = { it.name } // Usar el nombre del icono como clave única
            ) { icon ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = icon.name,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }
            }
        }
    }
}
