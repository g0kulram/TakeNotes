package com.gokul.takenotes.sidemenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import takenotes.composeapp.generated.resources.Res
import takenotes.composeapp.generated.resources.ic_take_notes

@Composable
fun SideMenuContent(
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.statusBars)
                .fillMaxHeight()
                .width(maxWidth * 0.6f)
                .background(MaterialTheme.colors.surface)
        ) {
            MenuHeader()

            Spacer(modifier = Modifier.weight(1f))

            ThemeRow(
                isDarkTheme = isDarkTheme,
                onToggleTheme = onThemeToggle,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun MenuHeader() {
    Row(
        modifier = Modifier
            .padding(horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_take_notes),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .size(40.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "Take Notes",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h6
        )
    }
}
