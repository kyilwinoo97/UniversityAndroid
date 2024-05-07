package com.assessment.universityandroid.app.di

import android.content.Context
import com.assessment.universityandroid.app.MyApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: MyApplication): Context = application.applicationContext
}