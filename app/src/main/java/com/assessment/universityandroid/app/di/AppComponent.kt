package com.assessment.universityandroid.app.di

import com.assessment.universityandroid.app.MyApplication
import com.assessment.universityandroid.core.di.CoreComponent
import com.assessment.universityandroid.core.di.scopes.AppScope
import dagger.Component

@AppScope
@Component(dependencies = [CoreComponent::class],
    modules = [AppModule::class])
interface AppComponent{
    fun inject(application: MyApplication)
}


