package com.assessment.universityandroid.app

import android.app.Application
import android.content.Context
import com.assessment.universityandroid.app.di.AppComponent
import com.assessment.universityandroid.app.di.DaggerAppComponent
import com.assessment.universityandroid.app.di.provider.AppComponentProvider
import com.assessment.universityandroid.core.di.CoreComponent
import com.assessment.universityandroid.core.di.DaggerCoreComponent
import com.assessment.universityandroid.core.di.helper.CoreComponentProvider
import com.assessment.universityandroid.core.di.modules.ContextModule

class MyApplication : Application(),CoreComponentProvider,AppComponentProvider{

    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
    }


    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            coreComponent = DaggerCoreComponent
                .builder()
                .contextModule(ContextModule(this))
                .build()
        }
        return coreComponent
    }

    override fun provideAppComponent(): AppComponent {
       val appComponent = DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
        return appComponent
    }

}