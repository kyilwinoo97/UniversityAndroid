package com.assessment.universityandroid.list_module.presentaion
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.universityandroid.core.database.University
import com.assessment.universityandroid.core.network.UniRepository
import com.assessment.universityandroid.core.network.UniRepositoryImpl
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class UniversityListViewModel @Inject constructor(private val uniRepository: UniRepositoryImpl) : ViewModel() {

//    init {
//        getUniversityByCountry("United Arab Emirates")
//    }
    fun getUniversityByCountry(country:String){
    Log.d("Call","NetworkCall")
        viewModelScope.launch {
            uniRepository.getUniversityByCountry(country).collect(){
                it ->
                print("data length -> ${ it.data?.size }")
            }
        }
    }
}