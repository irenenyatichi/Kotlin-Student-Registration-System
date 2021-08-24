package com.example.registration.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registration.models.RegistrationRequest
import com.example.registration.models.RegistrationResponse
import com.example.registration.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    var registrationLiveData = MutableLiveData<RegistrationResponse>()
    var regFailedLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()

    fun registerStudent(registrationRequest: RegistrationRequest){
        viewModelScope.launch {
            var response = userRepository.registerStudent(registrationRequest)
            if (response.isSuccessful){
                registrationLiveData.postValue(response.body())         //observes and waits for data to change and updates UI
            }
            else{
                regFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
