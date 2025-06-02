package com.gokul.takenotes

import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath

//class JVMPlatform: Platform {
//    override val name: String = "Java ${System.getProperty("java.version")}"
//}

actual fun getPlatform(): Platform = Platform.DESKTOP

actual fun getFileSystem(): FileSystem {
    return FileSystem.SYSTEM
}

actual fun getNoteStoragePath(): Path {
    return "notes.json".toPath()
}