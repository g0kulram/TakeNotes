package com.gokul.takenotes.sidemenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gokul.takenotes.models.NoteStorage
import com.gokul.takenotes.models.Notes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SideMenuViewModel: ViewModel() {
    private val _showSavedNotes = MutableStateFlow(false)
    val showSavedNotes = _showSavedNotes.asStateFlow()

    fun toggleShowSavedNotes() {
        _showSavedNotes.value = !_showSavedNotes.value
    }

    private val _savedNotes = MutableStateFlow<List<Notes>>(emptyList())
    val savedNotes = _savedNotes.asStateFlow()

    fun getSavedNotes() {
        viewModelScope.launch {
            _savedNotes.value = NoteStorage.loadNotes()
        }
    }
}