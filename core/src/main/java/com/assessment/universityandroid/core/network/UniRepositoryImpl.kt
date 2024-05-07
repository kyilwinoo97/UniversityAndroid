package com.assessment.universityandroid.core.network

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.room.withTransaction
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
    private var context: Application,
    val apiInterface: ApiInterface
) : UniRepository {
    override fun getUniversityByCountry(country: String): Flow<Resource<List<University>>> =
        networkBoundResource(
            query = {
                dao.getAllUniversity()
            },
            shouldFetch = {
                isInternetAvailable()
            },
            fetch = {
                delay(1000)
                apiInterface.getUniversityByCountry(country)
            },
            saveFetchResult = { data ->
                data?.let {
                    db.withTransaction {
//                        dao.deleteUni()
//                        dao.insertAllUni(it)
                    }
                }

            }
        )

    private fun isInternetAvailable(): Boolean {
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());

    }


}