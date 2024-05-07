package com.assessment.universityandroid.core.connectivity

import java.io.IOException

class ExperimentalOnlineChecker(private val runtime: Runtime) : OnlineChecker {
    override fun isOnline(): Boolean {
        try {
            val ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8")
            val exitValue = ipProcess.waitFor()
            return exitValue == 0
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return false
    }
}