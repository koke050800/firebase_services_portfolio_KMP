package com.koke050800.firebase_portfolio_kmp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import com.koke050800.firebase_portfolio_kmp.core.theme.FirebasePortfolioKMPTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.annotation.KoinExperimentalAPI
import com.koke050800.firebase_portfolio_kmp.core.router.NavigationRoot


@OptIn(ExperimentalMaterial3Api::class, KoinExperimentalAPI::class)
@Composable
@Preview
fun App() = FirebasePortfolioKMPTheme {NavigationRoot()}
