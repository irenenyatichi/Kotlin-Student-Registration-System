package com.example.studentregisteration.userViewModel

import android.app.VoiceInteractor
import androidx.lifecycle.MutableLiveData
import com.example.registration.models.RegistrationRequest
import com.example.registration.models.RegistrationResponse
import kotlin.coroutines.launch

class UserViewModel:ViewModel {
    var userRepository = UserRepository()
    var regResponseLiveData = MutableLiveData<RegistrationResponse>()
    var regErrorLiveData = MutableLiveData<String>()

    fun registerUser(registerationRequest:RegistrationRequest){
        viewModelScope.launch{
            var response = userRepository.registerUser(registerationRequest)
            if (response.isSuccessful){
                regResponseLiveData.postValue(response.body())
            }
            else{
                regErrorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}