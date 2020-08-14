@file:Suppress("MemberVisibilityCanBePrivate")

import java.io.File
import java.io.FileInputStream
import java.util.Properties

object VersionCode {

    fun readVersionCode(versionCodeAppName: String, minVersionCode: Int, increment: Boolean = false): Int {
        val versionsFilename = "$versionCodeAppName.properties"
        val versionCodesDirname = "${System.getProperty("user.home")}/.app-version-codes"

        val versionsDir = File(versionCodesDirname)
        if (!versionsDir.exists() && !versionsDir.mkdirs()) {
            throw IllegalStateException("Cannot create versions directory [${versionsDir.absolutePath}]")
        }

        val versionPropsFile = File(versionsDir, versionsFilename)
        val versionProps = Properties()
        if (versionPropsFile.canRead()) {
            val reader = FileInputStream(versionPropsFile)
            versionProps.load(reader)
            reader.close()
        } else {
            println("Failed to read properties file [${versionPropsFile.absolutePath}]")
            versionProps["VERSION_CODE"] = minVersionCode.toString()
        }

        var versionCode = (versionProps["VERSION_CODE"] as String).toInt()

        if (versionCode < minVersionCode) {
            versionCode = minVersionCode
        }

        println("Current build will use versionCode [$versionCode]")

        if (increment) {
            versionCode++
            versionPropsFile.writeText("VERSION_CODE=$versionCode")
            println("Incremented versionCode to [$versionCode]")
        }

        return versionCode
    }

    fun incrementVersionCode(versionCodeAppName: String, minVersionCode: Int) {
        readVersionCode(versionCodeAppName, minVersionCode, true)
    }
}