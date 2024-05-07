package com.assessment.universityandroid.core.di.modules

import com.assessment.universityandroid.core.connectivity.ExperimentalOnlineChecker

import com.assessment.universityandroid.core.connectivity.OnlineChecker
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class OnlineCheckerModule {

    @Singleton
    @Provides
    fun onlineChecker(): OnlineChecker {
        val runtime = Runtime.getRuntime()
        return ExperimentalOnlineChecker(runtime)
    }
}