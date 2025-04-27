package com.gokul.takenotes.editor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gokul.takenotes.theme.Grey
import com.gokul.takenotes.theme.LocalThemeController

@Composable
fun EditorMain(
    onOpenMenu : () -> Unit
) {
    var text by remember { mutableStateOf("") }
    val themeController = LocalThemeController.current

    BoxWithConstraints {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface)
                .windowInsetsPadding(WindowInsets.statusBars)
        ) {
            TopAppBar(
                title = {
                    Text(
                        text = "Take Notes",
                        color = MaterialTheme.colors.onBackground
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onOpenMenu
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Side Menu",
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                }
            )

            BasicTextField(
                value = text,
                onValueChange = { text = it },
                textStyle = TextStyle(
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 16.sp
                ),
                singleLine = false,
                cursorBrush = SolidColor(MaterialTheme.colors.onBackground),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ) {
                        if (text.isEmpty()) {
                            Text(
                                text = "Start Typing",
                                color = Color.Gray
                            )
                        }
                        innerTextField()
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}