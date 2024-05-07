package com.assessment.universityandroid.core.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UniversityDao {
    @Query("SELECT * FROM university_table")
    fun getAllUniversity(): Flow<List<University>>
}