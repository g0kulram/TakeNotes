package com.gokul.takenotes

import android.content.Context
import android.os.Build
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toOkioPath
import java.io.File

lateinit var androidContext: Context
fun initContext(context: Context) {
    androidContext = context.applicationContext
}

actual fun getPlatform(): Platform = Platform.ANDROID

actual fun getFileSystem(): FileSystem {
    return FileSystem.SYSTEM
}

actual fun getNoteStoragePath(): Path {
    val context = androidContext
    val file = File(context.filesDir, "notes.json")
    return file.toOkioPath()
}