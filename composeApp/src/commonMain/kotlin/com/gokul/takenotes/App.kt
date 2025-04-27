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
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val controller = remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val themeController = remember(controller.value) {
        ThemeController(
            isDark = controller.value,
            toggle = { controller.value = !controller.value }
        )
    }

    CompositionLocalProvider(LocalThemeController provides themeController) {
        AppTheme(
            darkEnabled = themeController.isDark
        ) {
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    SideMenuContent(isDarkTheme = themeController.isDark) {
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