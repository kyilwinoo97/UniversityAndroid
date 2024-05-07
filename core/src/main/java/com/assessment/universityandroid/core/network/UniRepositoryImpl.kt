package com.assessment.universityandroid.core.network

import androidx.room.withTransaction
import com.assessment.universityandroid.core.connectivity.OnlineChecker
import com.assessment.universityandroid.core.database.UniDatabase
import com.assessment.universityandroid.core.database.University
import com.assessment.universityandroid.core.database.UniversityDao
import com.assessment.universityandroid.core.network.data.networkBoundResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UniRepositoryImpl @Inject constructor(
    private var dao: UniversityDao,
    private var db: UniDatabase,
    val apiInterface: ApiInterface,
    val onlineChecker: OnlineChecker,
) : UniRepository {
    override fun getUniversityByCountry(country: String): Flow<Resource<List<University>>> =
        networkBoundResource(
            query = {
                dao.getAllUniversity()
            },
            shouldFetch = {
               onlineChecker.isOnline()
            },
            fetch = {
                delay(1000)
               apiInterface.getUniversityByCountry(country)
            },
            saveFetchResult = {
            data ->
                data?.let {
                    db.withTransaction {
                        dao.insertAllUni(data)
                    }
                }

            }
        )



}