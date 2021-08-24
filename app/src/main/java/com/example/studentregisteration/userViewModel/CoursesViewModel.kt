package com.example.registration.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registration.models.CoursesResponse
import com.example.registration.repository.CoursesRepository
import kotlinx.coroutines.launch

class CoursesViewModel: ViewModel() {
        var coursesLiveData = MutableLiveData<List<CoursesResponse>>()
        var coursesFailedLiveData = MutableLiveData<String>()
        var coursesRepository = CoursesRepository()

        fun coursesList(accessToken: String){
            viewModelScope.launch {
                var response = coursesRepository.courses(accessToken)
                if (response.isSuccessful){
                    coursesLiveData.postValue(response.body())
                }
                else{
                    coursesFailedLiveData.postValue(response.errorBody()?.string())
                }
            }
        }
    }
