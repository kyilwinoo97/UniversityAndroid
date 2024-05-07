package com.assessment.universityandroid.core.di

import android.content.Context
import com.assessment.universityandroid.core.database.UniversityDao
import com.assessment.universityandroid.core.di.modules.ContextModule
import com.assessment.universityandroid.core.di.modules.DatabaseModule
import com.assessment.universityandroid.core.di.modules.NetworkModule
import com.assessment.universityandroid.core.network.ApiInterface
import com.assessment.universityandroid.core.network.UniRepositoryImpl
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        DatabaseModule::class,
    ]
)
interface CoreComponent {
    fun context(): Context
    fun apiInterFace(): ApiInterface
    fun repository(): UniRepositoryImpl
    fun uniDao(): UniversityDao

}