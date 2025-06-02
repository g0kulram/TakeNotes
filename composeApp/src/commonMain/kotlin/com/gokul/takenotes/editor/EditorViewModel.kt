package com.gokul.takenotes.editor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gokul.takenotes.models.NoteStorage
import com.gokul.takenotes.models.Notes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EditorViewModel:ViewModel() {
    private val _noteTitle = MutableStateFlow<String?>(null)
    val noteTitle = _noteTitle.asStateFlow()

    fun updateNoteTitle(title: String) {
        _noteTitle.value = title
    }

    private val _noteText = MutableStateFlow("")
    val noteText = _noteText.asStateFlow()

    fun updateNoteText(text: String) {
        _noteText.value = text
    }

    fun saveNote() {
        var note = Notes(
            title = "First Note",
            content = _noteText.value
        )
        _note.value.let {
            if (it != null) {
                note = it.copy(
                    title = _noteTitle.value ?: "Untitled",
                    content = _noteText.value
                )
            }
        }
        viewModelScope.launch {
            NoteStorage.saveNote(note = note)
        }
    }

    private val _note = MutableStateFlow<Notes?>(null)
    val note = _note.asStateFlow()

    fun getNote(notes: Notes) {
        _note.value = notes
        _noteTitle.value = notes.title
        _noteText.value = notes.content
    }

    fun createNote() {
        _note.value = null
        _noteTitle.value = null
        _noteText.value = ""
    }
}