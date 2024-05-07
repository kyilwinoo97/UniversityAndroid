package com.assessment.universityandroid.core.di.helper

import android.content.Context
import com.assessment.universityandroid.core.di.CoreComponent

object CoreInjectHelper {
    fun provideCoreComponent(applicationContext: Context): CoreComponent {
        return if (applicationContext is CoreComponentProvider) {
            (applicationContext as CoreComponentProvider).provideCoreComponent()
        } else {
            throw IllegalStateException("The application context you have passed does not implement CoreComponentProvider")
        }
    }
}