package com.gokul.takenotes

import okio.FileSystem

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun getFileSystem(): FileSystem