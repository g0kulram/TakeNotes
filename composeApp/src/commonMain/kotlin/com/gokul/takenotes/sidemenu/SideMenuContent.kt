package com.gokul.takenotes.sidemenu

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.NoteAdd
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gokul.takenotes.models.Notes
import org.jetbrains.compose.resources.painterResource
import takenotes.composeapp.generated.resources.Res
import takenotes.composeapp.generated.resources.ic_take_notes

@Composable
fun SideMenuContent(
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit,
    presentNotes: (Notes) -> Unit,
    createNewNotes: () -> Unit
) {
    val viewModel = SideMenuViewModel()
    val showSavedNotes = viewModel.showSavedNotes.collectAsState()
    val savedNotes = viewModel.savedNotes.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getSavedNotes()
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.statusBars)
                .fillMaxHeight()
                .widthIn(max = 300.dp)
                .width(maxWidth * 0.6f)
                .background(MaterialTheme.colors.surface)
        ) {
            MenuHeader()

            Spacer(modifier = Modifier.height(10.dp))

            SideMenuButton(
                menuIcon = Icons.Default.NoteAdd,
                title = "Create Note",
                onClick = {
                    createNewNotes()
                },
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
            )

            SideMenuButton(
                title = "Saved Notes",
                menuIcon = Icons.Default.Folder,
                onClick = {
                    viewModel.getSavedNotes()
                    viewModel.toggleShowSavedNotes()
                },
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
            )
            AnimatedVisibility(visible = showSavedNotes.value) {
                SavedNotesList(
                    notesList = savedNotes.value,
                    onNoteClick = {
                        presentNotes(it)
                        viewModel.toggleShowSavedNotes()
                    },
                    modifier = Modifier
                        .padding(start = 30.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            SideMenuButton(
                menuIcon = Icons.Default.Settings,
                title = "Settings",
                onClick = {},
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
            )

            SideMenuButton(
                menuIcon = Icons.Default.Info,
                title = "About Take Notes",
                onClick = {},
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
            )

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
