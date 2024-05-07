package com.assessment.universityandroid.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UniversityDao {
    @Query("SELECT * FROM university_table")
    fun getAllUniversity(): Flow<List<University>>

    @Query("DELETE FROM university_table")
    suspend fun deleteAllUniversity()

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertAllUni(lst: List<University>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUni(university: University)

}