package com.assessment.universityandroid.core.network

import com.assessment.universityandroid.core.database.University
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("/search")
    suspend fun getUniversityByCountry(@Query("country") country:String):Any
}