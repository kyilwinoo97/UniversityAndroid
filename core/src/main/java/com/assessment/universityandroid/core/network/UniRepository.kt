package com.assessment.universityandroid.core.network

import com.assessment.universityandroid.core.database.University
import kotlinx.coroutines.flow.Flow


interface UniRepository {
    fun getUniversityByCountry(country: String): Flow<Resource<List<University>>>

}