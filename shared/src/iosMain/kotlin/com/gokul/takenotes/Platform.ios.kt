package com.gokul.takenotes

import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask
import platform.UIKit.UIDevice

//class IOSPlatform: Platform {
//    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
//}

actual fun getPlatform(): Platform = Platform.IOS

actual fun getFileSystem(): FileSystem {
    return FileSystem.SYSTEM
}

actual fun getNoteStoragePath(): Path {
    val paths = NSSearchPathForDirectoriesInDomains(
        directory = NSDocumentDirectory,
        domainMask = NSUserDomainMask,
        expandTilde = true
    )
    val documentsDirectory = paths.first() as String
    val filePath = "$documentsDirectory/notes.json"
    return filePath.toPath()
}