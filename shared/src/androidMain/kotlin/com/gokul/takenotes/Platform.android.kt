package com.gokul.takenotes

import android.os.Build
import okio.FileSystem
import okio.Path

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun getFileSystem(): FileSystem {
    return FileSystem.SYSTEM
}