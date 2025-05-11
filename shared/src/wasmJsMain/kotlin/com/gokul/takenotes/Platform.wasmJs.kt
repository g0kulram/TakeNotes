package com.gokul.takenotes

import okio.FileSystem

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()

actual fun getFileSystem(): FileSystem {
    return FileSystem
}