package com.gokul.takenotes

import okio.FileSystem
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual fun getFileSystem(): FileSystem {
    return FileSystem.SYSTEM
}