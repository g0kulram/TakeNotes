package com.gokul.takenotes

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "TakeNotes",
    ) {
        App()
    }
}