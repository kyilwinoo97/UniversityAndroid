package com.assessment.universityandroid.core.di.modules

import android.app.Application
import android.content.Context
import androidx.multidex.BuildConfig
import com.assessment.universityandroid.core.database.UniDatabase
import com.assessment.universityandroid.core.database.UniversityDao
import com.assessment.universityandroid.core.network.ApiInterface
import com.assessment.universityandroid.core.network.UniRepository
import com.assessment.universityandroid.core.network.UniRepositoryImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    private val baseUrl = "http://universities.hipolabs.com"

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }


    @Singleton
    @Provides
    fun provideHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor(interceptor)

//        if (BuildConfig.DEBUG) {
//            clientBuilder.addInterceptor(interceptor)
//
//        }
        return clientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder() =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiInterface::class.java)


    @Singleton
    @Provides
    fun provideRepository(dao: UniversityDao,db:UniDatabase,
                          service: ApiInterface) = UniRepositoryImpl(
        dao = dao,
        db =  db,
        apiInterface = service
    )
}