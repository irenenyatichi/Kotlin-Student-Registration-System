package com.example.registration.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import com.example.registration.Constants
import com.example.registration.databinding.ActivityMainBinding
import com.example.registration.models.LogInRequest
import com.example.registration.models.RegistrationRequest
import com.example.registration.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    val userViewModel: UserViewModel by viewModels()

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nationality = arrayListOf<String>("Kenyan", "Ugandan", "Rwandese", "South Sudanes")
        var nationalityAdapter =ArrayAdapter(baseContext, android.R.layout.simple_spinner_item, nationality)
        binding.spNationality.adapter=nationalityAdapter
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.btnLogIn1.setOnClickListener {
            var intent = Intent(baseContext, LogIn::class.java)
            startActivity(intent)
        sharedPreferences = getSharedPreferences(Constants.SHAREDPREFS, Context.MODE_PRIVATE)
            redirectUser()
        }
    }

    fun redirectUser(){
        var accessToken = sharedPreferences.getString(Constants.ACCESSTOKEN, Constants.EMPTY_STRING)
        if (accessToken!!.isNotEmpty()){
            startActivity(Intent(baseContext, CoursesActivity::class.java))
        }
        else{
            startActivity(Intent(baseContext, LogIn::class.java))
        }
    }


    //Read on android activity life cycle
    override fun onResume() {
        super.onResume()
        binding.btnRegister.setOnClickListener{
            if (binding.etName.text.toString().isEmpty()||
                binding.etDob.text.toString().isEmpty()||
                binding.etPhoneNumber.text.toString().isEmpty()||
                binding.etEmail.text.toString().isEmpty() ||
                binding.etPassword.text.toString().isEmpty()
            ){
                binding.etName.setError("Name required")
                binding.etDob.setError("Date of birth required")
                binding.etPhoneNumber.setError("Number required")
                binding.etEmail.setError("Email required")
                binding.etPassword.setError("Password required")

            }

            var regRequest = RegistrationRequest(
                name = binding.etName.text.toString(),
                phoneNumber = binding.etPhoneNumber.text.toString(),
                email = binding.etEmail.text.toString(),
                dateOfBirth = binding.etDob.text.toString(),
                password = binding.etPassword.text.toString(),
                nationality =binding.spNationality.selectedItem.toString().uppercase()
            )
            var intent = Intent(baseContext, LogIn::class.java)
            startActivity(intent)

            userViewModel.registerStudent(regRequest)
        }
        userViewModel.registrationLiveData.observe(this, { regResponse->
            if (!regResponse.studentId.isNullOrEmpty()){
                Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.regFailedLiveData.observe(this, { error->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }




//        castViews()
//        clickRegister()

//    lateinit var etName: EditText
//    lateinit var etDob: EditText
//    lateinit var spNationality: Spinner
//    lateinit var etPhoneNumber: EditText
//    lateinit var etEmail: EditText
//    lateinit var btnRegister: Button
//    lateinit var etPassword: EditText

//var name = binding.etName.text.toString()
//var Dob = binding.etDob.text.toString()
//var phoneNumber = binding.etPassword.text.toString()
//var email = binding.etEmail.text.toString()
//var password = binding.etPassword.text.toString()


//    fun castViews(){
//        etName = findViewById(R.id.etName)
//        etDob  = findViewById(R.id.etDob)
//        spNationality = findViewById(R.id.spNationality)
//        etEmail = findViewById(R.id.etEmail)
//        etPhoneNumber = findViewById(R.id.etPhoneNumber)
//        btnRegister = findViewById(R.id.btnRegister)
//        etPassword = findViewById(R.id.etPassword)

//        val nationality = arrayOf("Kenyan", "Ugandan", "Rwandese", "South Sudanes")
//        var nationalityAdapter = ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, nationality)
//        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spNationality.adapter = nationalityAdapter
//
//    }
//    fun clickRegister(){
//        var error = false
//        btnRegister.setOnClickListener {
//            var name = etName.text.toString()
//            if (name.isEmpty()) {
//                error = true
//                etName.setError("Name is required")
//            }

//            var dob = etDob.text.toString()
//            if (dob.isEmpty()) {
//                error = true
//                etDob.setError("Date of birth is required")
//            }
//
//            var tilPassword = etPassword.text.toString()
//            if (tilPassword.isEmpty()) {
//                error = true
//                etPassword.setError("Input password")
//            }
//
//            var nationality = spNationality.selectedItem.toString()
//
//            var email = etEmail.text.toString()
//            if (email.isEmpty()) {
//                error = true
//                etEmail.setError("Email required")
//            }
//
//            var phoneNumber = etPhoneNumber.text.toString()
//            if (phoneNumber.isEmpty()) {
//                error = true
//                etPhoneNumber.setError("Input phone number")
//            }
//
//            var registrationRequest = RegistrationRequest(
//                name = name,
//                phoneNumber = phoneNumber,
//                email = email,
//                dateOfBirth = dob,
//                password = tilPassword
//            )
//
//            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
//            var request = retrofit.registerStudent(registrationRequest)
//            request.enqueue(object : Callback<RegistrationResponse> {
//
//                override fun onResponse(
//                    call: Call<RegistrationResponse>,
//                    response: Response<RegistrationResponse>
//                ) {
//                    if (response.isSuccessful) {
//                        Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG)
//                            .show()
//                    }
//                }
//
//                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
//                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//                }
//
//            })
//            val intent = Intent(baseContext, LogIn::class.java)
//            startActivity(intent)
//        }
//}
}
