package com.assessment.universityandroid.list_module.presentaion
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.assessment.universityandroid.core.database.University
import com.assessment.universityandroid.core.network.Resource
import com.assessment.universityandroid.core.network.UniRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class UniversityListViewModel @Inject constructor(private val uniRepository: UniRepositoryImpl) : ViewModel() {


    var universityObj by  mutableStateOf(UniversityObj(emptyList()).list)

    var universityList = MutableLiveData<Resource<List<University>>>()


    fun getUniversityByCountry(country:String){
        viewModelScope.launch {
            universityList = uniRepository.getUniversityByCountry(country).flowOn(Dispatchers.IO).asLiveData(Dispatchers.Main) as MutableLiveData<Resource<List<University>>>
//            uniRepository.getUniversityByCountry(country).collect{
//                when(it){
//                    is Resource.Success -> {
//                        universityObj = it.data!!
//                    }
//                    is Resource.Error -> {
//
//                    }
//                    is Resource.Loading -> {
//
//                    }
//                }
//            }
        }
    }
}
data class UniversityObj(
    var list: List<University> = emptyList()
) {
}