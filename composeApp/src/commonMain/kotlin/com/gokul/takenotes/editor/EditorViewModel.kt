package com.gokul.takenotes.editor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gokul.takenotes.models.NoteStorage
import com.gokul.takenotes.models.Notes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EditorViewModel:ViewModel() {
    private val _noteText = MutableStateFlow("")
    val noteText = _noteText.asStateFlow()

    fun updateNoteText(text: String) {
        _noteText.value = text
    }

    fun saveNote() {
        val note = Notes(
            title = "First Note",
            content = _noteText.value
        )
        viewModelScope.launch {
            NoteStorage.saveNote(note = note)
        }
    }
}