package com.gokul.takenotes.models

import kotlinx.datetime.Clock
import kotlinx.serialization.Serializable

@Serializable
data class Notes (
    val id: String = generateNoteId(),
    val title: String,
    val content: String,
    val timestamp: Long = Clock.System.now().toEpochMilliseconds()
    )

fun generateNoteId(): String {
    val timestamp = Clock.System.now().toEpochMilliseconds()
    val randomPart = (1..8).map {
        ('a'..'z').random()
    }.joinToString("")
    return "$timestamp-$randomPart"
}