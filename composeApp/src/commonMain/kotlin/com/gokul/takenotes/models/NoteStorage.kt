package com.gokul.takenotes.models

import com.gokul.takenotes.getFileSystem
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okio.Path
import okio.Path.Companion.toPath

object NoteStorage {
    private val json = Json { prettyPrint = true }
    private val fileSystem = getFileSystem()
    private val filePath: Path = "notes.json".toPath()

    suspend fun saveNote(note: Notes) {
        val notes = loadNotes().toMutableList()
        val index = notes.indexOfFirst { it.id == note.id }
        if (index >= 0) notes[index] = note else notes.add(note)
        fileSystem.write(filePath) {
            writeUtf8(json.encodeToString(notes))
        }
    }

    fun loadNotes(): List<Notes> {
        return if (fileSystem.exists(filePath)) {
            val content = fileSystem.read(filePath) { readUtf8() }
            json.decodeFromString(content)
        } else emptyList()
    }

    suspend fun getNoteById(id: String): Notes? {
        return loadNotes().find { it.id == id }
    }

    suspend fun deleteNote(id: String) {
        val updated = loadNotes().filterNot { it.id == id }
        fileSystem.write(filePath) {
            writeUtf8(json.encodeToString(updated))
        }
    }
}