package com.assessment.universityandroid.core.network

import com.assessment.universityandroid.core.database.University
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/search")
    suspend fun getUniversityByCountry(@Path("country") country:String):List<University>
}