package com.gokul.takenotes

import okio.FileSystem

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()

actual fun getFileSystem(): FileSystem {
    return FileSystem.SYSTEM
}