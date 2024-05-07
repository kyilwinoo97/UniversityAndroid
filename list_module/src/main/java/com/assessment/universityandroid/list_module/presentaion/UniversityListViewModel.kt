package com.assessment.universityandroid.list_module.presentaion
import android.util.Log
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

    init {
        getUniversityByCountry("United Arab Emirates")
    }

    fun getUniversityByCountry(country:String){
        viewModelScope.launch {
            universityList = uniRepository.getUniversityByCountry(country).flowOn(Dispatchers.IO).asLiveData(Dispatchers.Main) as MutableLiveData<Resource<List<University>>>
        }
    }
}
data class UniversityObj(
    var list: List<University> = emptyList()
) {
}