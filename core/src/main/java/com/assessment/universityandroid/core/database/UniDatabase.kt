package com.assessment.universityandroid.core.database

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [University::class],
    exportSchema = false,
    version = 1
)
@TypeConverters(Converter::class)
abstract class UniDatabase: RoomDatabase() {
    abstract fun universityDao(): UniversityDao
}
val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // We can perform actions like
        /*database.execSQL("CREATE TABLE `Fruit` (`id` INTEGER, `name` TEXT, " +
                "PRIMARY KEY(`id`))")*/
    }
}