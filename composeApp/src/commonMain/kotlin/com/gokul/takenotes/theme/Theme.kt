package com.gokul.takenotes.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.russhwolf.settings.Settings

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
    val isDark: State<Boolean>,
    val toggle: () -> Unit
)

object ThemeManager {
    private val settings = Settings()

    private const val THEME_KEY = "isDarkTheme"

    fun loadTheme(): Boolean {
        return settings.getBoolean(key = THEME_KEY, defaultValue = false)
    }

    fun saveTheme(isDark: Boolean) {
        settings.putBoolean(key = THEME_KEY, value = isDark)
    }
}

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