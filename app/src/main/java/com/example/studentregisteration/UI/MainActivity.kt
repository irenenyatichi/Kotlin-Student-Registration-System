package com.example.studentregisteration.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.*
import com.example.registration.R
import com.example.registration.models.RegistrationRequest
import com.example.registration.ui.codeHiveRegistration
import com.example.studentregisteration.userViewModel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ScriptGroup.Binding.root)
        castViews()
        onClick()
    }

    fun setupSpinner() {
        progressBar3=findViewById(R.id.progressBar3)
        tilname = findViewById(R.id.tilname)
        etdob = findViewById(R.id.etdob)
        spnationality = findViewById(R.id.spnationality)
        etpswd = findViewById(R.id.etpswd)
        etphone = findViewById(R.id.etphone)
        etemail = findViewById(R.id.etemail)
        btn = findViewById(R.id.btn)
        btnnext=findViewById(R.id.btnnext)
        val nationality = arrayOf("Kenyan", "Ugandan", "Rwandan", "Sudanese", "South Sudanese")
        val nationalityAdapter =
                ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, nationality)
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnationality.adapter = nationalityAdapter

    }

    fun onClick() {
        btn.setOnClickListener {
            progressBar3.visibility=View.VISIBLE
            var name = tilname.text.toString()
            var dob = etdob.text.toString()
            var nationality = spnationality.selectedItem.toString().uppercase()
            var password = etpswd.text.toString()
            var phone = etphone.text.toString()
            var email = etemail.text.toString()
            if(name.isEmpty()||dob.isEmpty()||password.isEmpty()||phone.isEmpty()||email.isEmpty()){
                tilname.setError("please enter your name")
                etdob.setError("Please enter your date of birth")
                etpswd.setError("You must enter you ID number")
                etphone.setError("please enter your phone number")
                etemail.setError("please enter your email")
                Toast.makeText(baseContext,"This are your details :",Toast.LENGTH_LONG).show()
            }
            var intent=Intent(baseContext, codeHiveRegistration::class.java)
            startActivity(intent)
            var regRequest=RegistrationRequest(
                    name=name,phoneNumber = phone,email = email,dateOfBirth = dob,nationality = nationality,password = password
            )

            userViewModel.registerUser(regRequest)
//            var retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
//            var request=retrofit.registerStudent(regRequest)
//            request.enqueue(object : Callback<RegistrationResponse> {
//                override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {
//                    progressBar3.visibility=View.GONE
//                    if (response.isSuccessful){
//                        Toast.makeText(baseContext,"Your registration is successful",Toast.LENGTH_LONG).show()
//                    }
//                    else{
//                        Toast.makeText(baseContext,response.errorBody()?.toString(),Toast.LENGTH_LONG).show()
//
//                    }
//                }
//
//                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
//                    Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
//                    progressBar3.visibility=View.GONE
//
//
//                }
//            })
        }
        btnnext.setOnClickListener {
            var intent=Intent(baseContext, Loginctivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        userViewModel.regResponseLiveData.observe(this,{regResponse ->
            binding.pbRegisteration.visibility = View.GONE
            if (!regResponse.studentId.isNullOrEmpty()){
                Toast.makeText(baseContext,"Registeration Successful",Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.regErrorLiveData.observe(this,{error ->
            Toast.makeText(baseContext,"Registeration Successful",Toast.LENGTH_LONG).show()
        })

    }
}