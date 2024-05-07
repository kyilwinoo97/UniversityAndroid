package com.assessment.universityandroid.list_module.presentaion

import UniListModule
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.assessment.universityandroid.core.di.helper.CoreInjectHelper
import com.assessment.universityandroid.core.network.UniRepositoryImpl
import com.assessment.universityandroid.list_module.R
import com.assessment.universityandroid.list_module.di.ViewModelModule
import javax.inject.Inject


class UniListActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: UniversityListViewModel

    val country = "United Arab Emirates"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uni_list)
            DaggerUniListComponent
            .builder()
            .coreComponent(CoreInjectHelper.provideCoreComponent(applicationContext))
            .uniListModule(UniListModule(this))
            .build()
            .inject(this)

        if (viewModel != null){
           // viewModel.getUniversityByCountry(country)
        }
    }
}