package com.gokul.takenotes.sidemenu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gokul.takenotes.models.NoteStorage
import com.gokul.takenotes.models.Notes

@Composable
fun SavedNotesList(
    modifier: Modifier,
    notesList: List<Notes>
) {
    val noteTitles = listOf("Note 1", "Note 2", "Note 3")
    val notesModifiedDates = listOf(1746975480000L, 1746889080000L, 1746197880000L)

    Column(
        modifier = modifier
    ) {
        Divider(
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.5f),
            modifier = Modifier
                .padding(vertical = 5.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(notesList) {
                SavedNoteCell(
                    title = it.title,
                    dateModifiedMillis = it.timestamp
                )
            }
        }
    }
}

@Composable
fun SavedNoteCell(
    title: String,
    dateModifiedMillis: Long
) {
    Row {
        Text(
            text = title,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "2 days",
            color = MaterialTheme.colors.onBackground
        )
    }
}