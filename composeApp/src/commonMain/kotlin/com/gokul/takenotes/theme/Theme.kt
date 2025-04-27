package com.gokul.takenotes.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

typealias Bool = Boolean

val LightColorScheme = darkColors(
    primary = Color(0xFF3F51B5),
    background = Color.White,
    surface = Color(0xFFF5F5F5),
    onPrimary = Color.White,
    onBackground = Color.Black
)

val DarkColorScheme = darkColors(
    primary = Color(0xFFBB86FC),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.Black,
    onBackground = Color.White
)

data class ThemeController(
    val isDark: Boolean,
    val toggle: () -> Unit
)

val LocalThemeController = staticCompositionLocalOf<ThemeController> {
    error("No ThemeController provided")
}

@Composable
fun AppTheme(
    darkEnabled: Bool = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkEnabled) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colors = colors,
        content = content
    )
}