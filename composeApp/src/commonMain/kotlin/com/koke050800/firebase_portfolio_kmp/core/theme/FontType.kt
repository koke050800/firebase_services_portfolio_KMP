package com.koke050800.firebase_portfolio_kmp.core.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import firebase_portfolio_kmp.composeapp.generated.resources.Res
import firebase_portfolio_kmp.composeapp.generated.resources.jost
import firebase_portfolio_kmp.composeapp.generated.resources.oswald_bold
import firebase_portfolio_kmp.composeapp.generated.resources.oswald_extralight
import firebase_portfolio_kmp.composeapp.generated.resources.oswald_light
import firebase_portfolio_kmp.composeapp.generated.resources.oswald_medium
import firebase_portfolio_kmp.composeapp.generated.resources.oswald_regular
import firebase_portfolio_kmp.composeapp.generated.resources.oswald_semibold
import org.jetbrains.compose.resources.Font

enum class AppFontFamily{
    Jost,
    Oswald,
}

class FontType {

    companion object {
        private val typography = Typography()

        @Composable
        private fun oswaldFontFamily(): FontFamily = FontFamily(
            Font(Res.font.oswald_bold, FontWeight.Bold),
            Font(Res.font.oswald_extralight, FontWeight.ExtraLight),
            Font(Res.font.oswald_light, FontWeight.Light),
            Font(Res.font.oswald_medium, FontWeight.Medium),
            Font(Res.font.oswald_regular, FontWeight.Normal),
            Font(Res.font.oswald_semibold, FontWeight.SemiBold),
            Font(Res.font.oswald_extralight, FontWeight.Thin),
            Font(Res.font.oswald_bold, FontWeight.ExtraBold),
            Font(Res.font.oswald_bold, FontWeight.Black)
        )

        @Composable
        private fun jostTypography(): FontFamily = FontFamily(
            Font(Res.font.jost, FontWeight.Normal),
        )


        @Composable
        fun getAppTypography(appFontFamily: AppFontFamily): Typography {
             val fontFamily  = when(appFontFamily){
                AppFontFamily.Jost -> jostTypography()
                AppFontFamily.Oswald -> oswaldFontFamily()
            }
            return Typography(
                displayLarge = typography.displayLarge.copy(fontFamily = fontFamily),
                displayMedium = typography.displayMedium.copy(fontFamily = fontFamily),
                displaySmall = typography.displaySmall.copy(fontFamily = fontFamily),
                headlineLarge = typography.headlineLarge.copy(fontFamily = fontFamily),
                headlineMedium = typography.headlineMedium.copy(fontFamily = fontFamily),
                headlineSmall = typography.headlineSmall.copy(fontFamily = fontFamily),
                titleLarge = typography.titleLarge.copy(fontFamily = fontFamily),
                titleMedium = typography.titleMedium.copy(fontFamily = fontFamily),
                titleSmall = typography.titleSmall.copy(fontFamily = fontFamily),
                bodyLarge = typography.bodyLarge.copy(fontFamily = fontFamily),
                bodyMedium = typography.bodyMedium.copy(fontFamily = fontFamily),
                bodySmall = typography.bodySmall.copy(fontFamily = fontFamily),
                labelLarge = typography.labelLarge.copy(fontFamily = fontFamily),
                labelMedium = typography.labelMedium.copy(fontFamily = fontFamily),
                labelSmall = typography.labelSmall.copy(fontFamily = fontFamily),
            )
        }


    }
}

