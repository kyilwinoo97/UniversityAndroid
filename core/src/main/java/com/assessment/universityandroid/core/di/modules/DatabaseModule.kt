package com.assessment.universityandroid.core.di.modules

import android.content.Context
import androidx.room.Room
import com.assessment.universityandroid.core.database.MIGRATION_1_2
import com.assessment.universityandroid.core.database.UniDatabase
import com.assessment.universityandroid.core.database.UniversityDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideUniDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            UniDatabase::class.java,
            "uni_db"
        ).addMigrations(MIGRATION_1_2)
            .build()

    @Singleton
    @Provides
    fun provideDao(uniDb: UniDatabase) =
        uniDb.universityDao()

//    @Singleton
//    @Provides
//    fun provideRepository(
//        dao: UniversityDao
//    ) = UniReposiotry(dao)
}