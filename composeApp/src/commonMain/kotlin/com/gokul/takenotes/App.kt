package com.gokul.takenotes

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.gokul.takenotes.editor.EditorMain
import com.gokul.takenotes.sidemenu.SideMenuContent
import com.gokul.takenotes.theme.AppTheme
import com.gokul.takenotes.theme.LocalThemeController
import com.gokul.takenotes.theme.ThemeController
import com.gokul.takenotes.theme.ThemeManager
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val controller = remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val isDark = remember { mutableStateOf(ThemeManager.loadTheme()) }

    val themeController = remember {
        ThemeController(
            isDark = isDark,
            toggle = {
                isDark.value = !isDark.value
                ThemeManager.saveTheme(isDark.value)
            }
        )
    }

    CompositionLocalProvider(LocalThemeController provides themeController) {
        AppTheme(
            darkEnabled = themeController.isDark.value
        ) {
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    SideMenuContent(isDarkTheme = themeController.isDark.value) {
                        themeController.toggle()
                    }
                }
            ) {
                EditorMain(
                    onOpenMenu = { scope.launch { drawerState.open() } }
                )
            }
        }
    }

}