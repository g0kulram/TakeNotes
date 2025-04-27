package com.gokul.takenotes.sidemenu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ThemeRow(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .padding(horizontal = 5.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
//        Text(
//            text = "Theme",
//            color = MaterialTheme.colors.onBackground
//        )

        Icon(
            imageVector = Icons.Filled.LightMode,
            contentDescription = "Light Mode",
            tint = Color(0xFFFFC107)
        )
        Switch(
            checked = isDarkTheme,
            onCheckedChange = { onToggleTheme()},
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.LightGray,
                checkedTrackColor = Color(0xFFB00080), // light purple
                uncheckedThumbColor = Color.LightGray,
                uncheckedTrackColor = Color.Gray
            )
        )
        Icon(
            imageVector = Icons.Filled.DarkMode,
            contentDescription = "Dark Mode",
            tint = Color(0xFF7986CB)
        )
    }
}