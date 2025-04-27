package com.gokul.takenotes.editor

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.gokul.takenotes.theme.LocalThemeController

@Composable
fun TopBar(
    modifier: Modifier,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text =  if (isDarkTheme) "\uD83C\uDF19" else "☀\uFE0F",
            fontSize = 16.sp
        )
        Switch(
            checked = isDarkTheme,
            onCheckedChange = { onToggleTheme()},
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.LightGray, // purple
                checkedTrackColor = Color(0xFF800080), // light purple
                uncheckedThumbColor = Color.LightGray,
                uncheckedTrackColor = Color.Gray
            )
        )
    }
}

fun Modifier.topBorder(
    color: Color,
    height: Float,
) = this.drawWithContent {
    drawContent()
    drawLine(
        color = color,
        start = Offset(0f, 0f),
        end = Offset(size.width, 0f),
        strokeWidth = height,
    )
}

fun Modifier.rightBorder(
    color: Color,
    width: Float,
) = this.drawWithContent {
    drawContent()
    drawLine(
        color = color,
        start = Offset(size.width, 0f),
        end = Offset(size.width, size.height),
        strokeWidth = width,
    )
}

fun Modifier.bottomBorder(
    color: Color,
    height: Float,
) = this.drawWithContent {
    drawContent()
    drawLine(
        color = color,
        start = Offset(0f, size.height),
        end = Offset(size.width, size.height),
        strokeWidth = height,
    )
}

fun Modifier.leftBorder(
    color: Color,
    width: Float,
) = this.drawWithContent {
    drawContent()
    drawLine(
        color = color,
        start = Offset(0f, 0f),
        end = Offset(0f, size.height),
        strokeWidth = width,
    )
}