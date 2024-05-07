package com.assessment.universityandroid.list_module.presentaion
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.universityandroid.core.network.Resource
import com.assessment.universityandroid.core.network.UniRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class UniversityListViewModel @Inject constructor(private val uniRepository: UniRepositoryImpl) : ViewModel() {

    init {
        getUniversityByCountry("United Arab Emirates")
    }
    private fun getUniversityByCountry(country:String){
        viewModelScope.launch {
            uniRepository.getUniversityByCountry(country).collect{
                when(it){
                    is Resource.Success -> {
                        //data
                    }
                    is Resource.Error -> {

                    }
                    is Resource.Loading -> {

                    }
                }
            }
        }
    }
}