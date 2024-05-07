package com.assessment.universityandroid.list_module.presentaion

import UniListModule
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assessment.universityandroid.core.database.University
import com.assessment.universityandroid.core.di.helper.CoreInjectHelper
import com.assessment.universityandroid.core.network.UniRepositoryImpl
import com.assessment.universityandroid.list_module.R
import com.assessment.universityandroid.list_module.adapter.RecyclerAdapter
import com.assessment.universityandroid.list_module.databinding.ActivityUniListBinding
import com.assessment.universityandroid.list_module.di.ViewModelModule
import javax.inject.Inject


class UniListActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: UniversityListViewModel

    private val country = "United Arab Emirates"
    lateinit var binding : ActivityUniListBinding
    lateinit var adapter: RecyclerAdapter
    var list: List<University> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUniListBinding.inflate(layoutInflater)
        setContentView(binding.root)
            DaggerUniListComponent
            .builder()
            .coreComponent(CoreInjectHelper.provideCoreComponent(applicationContext))
            .uniListModule(UniListModule(this))
            .build()
            .inject(this)

        if (viewModel != null){
            viewModel.getUniversityByCountry(country)
        }
        setUpRecyclerView()
        viewModel.universityList.observe(this) {
            it.data?.let {
                data ->
                val layoutManager = LinearLayoutManager(this)
                binding.recyclerView.layoutManager = layoutManager
                adapter = RecyclerAdapter(data)
                binding.recyclerView.adapter = adapter
            }
        }

    }

    private fun setUpRecyclerView() {

    }

    override fun onResume() {
        if (viewModel != null){
            viewModel.getUniversityByCountry(country)
        }
        super.onResume()
    }
}