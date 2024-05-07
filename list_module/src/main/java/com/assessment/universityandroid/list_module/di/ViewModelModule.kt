package com.assessment.universityandroid.list_module.di

import androidx.lifecycle.ViewModel
import com.assessment.universityandroid.core.di.helper.ViewModelKey
import com.assessment.universityandroid.list_module.presentaion.UniversityListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UniversityListViewModel::class)
    abstract fun bindsListViewModel(viewModel: UniversityListViewModel?): ViewModel?
}