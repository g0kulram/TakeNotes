package com.gokul.takenotes.editor

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EditorMain(
    viewModel: EditorViewModel,
    onOpenMenu : () -> Unit
) {
    val title = viewModel.noteTitle.collectAsState()
    val text = viewModel.noteText.collectAsState()
    val showSaveAsPopup = viewModel.showSaveAsPopup.collectAsState()
    val saveAsTitle = viewModel.saveAsTitle.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            floatingActionButton = {
                EditorFAB {
                    viewModel.onSaveClicked()
                }
            },
            floatingActionButtonPosition = FabPosition.End
        ) {
            BoxWithConstraints {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.surface)
                        .windowInsetsPadding(WindowInsets.statusBars)
                ) {
                    TopAppBar(
                        title = {
                            Column {
                                Text(
                                    text = "Take Notes",
                                    color = MaterialTheme.colors.onBackground
                                )
                                Text(
                                    text = title.value ?: "Untitled",
                                    color = Color.Gray,
                                    fontSize = 12.sp
                                )
                            }
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
                        value = text.value,
                        onValueChange = { viewModel.updateNoteText(text = it) },
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
                                if (text.value.isEmpty()) {
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

        AnimatedVisibility(
            visible = showSaveAsPopup.value,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(if (MaterialTheme.colors.isLight) Color.Black.copy(alpha = 0.6f) else Color.White.copy(alpha = 0.1f))
                    .clickable {
                        viewModel.hideSaveAsPopup()
                    }
            ) {
                EditorSaveAsPopup(
                    titleValue = saveAsTitle.value,
                    onValueChange = viewModel::updateSaveAsTitle,
                    onSave = {
                        viewModel.saveNote()
                        viewModel.hideSaveAsPopup()
                    },
                    onClose = viewModel::hideSaveAsPopup,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colors.background)
                )
            }
        }
    }
}