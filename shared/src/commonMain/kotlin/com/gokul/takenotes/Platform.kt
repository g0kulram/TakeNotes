package com.gokul.takenotes

import okio.FileSystem
import okio.Path

enum class Platform {
    ANDROID,
    IOS,
    DESKTOP,
    WASM
}

expect fun getPlatform(): Platform

expect fun getFileSystem(): FileSystem

expect fun getNoteStoragePath(): Path