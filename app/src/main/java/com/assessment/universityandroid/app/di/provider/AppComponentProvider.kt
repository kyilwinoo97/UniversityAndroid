package com.assessment.universityandroid.app.di.provider

import com.assessment.universityandroid.app.di.AppComponent
import com.assessment.universityandroid.core.di.CoreComponent

interface AppComponentProvider {
    fun provideAppComponent(): AppComponent
}