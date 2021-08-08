package com.example.studentregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    lateinit var etname: EditText
    lateinit var etDateOfBirth:EditText
    lateinit var etNationality:EditText
    lateinit var etIdNumber:EditText
    lateinit var etPhone:EditText
    lateinit var etEmailAddress:EditText
    lateinit var btnRegister:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName  = findViewById(R.id.etName)
//        val etName=findViewById(R.id.etName)
//        val etDateOfBirth=findViewById(R.id.etDateOfBirth)
//        val etNationality=findViewById(R.id.etNationality)
//        val etIdNumber=findViewById(R.id.etIdNumber)
//        val etPhone=findViewById(R.id.etPhone)
//        val etEmailAddress= findViewById(R.id.etEmailAdress)
//        val btnRegister=findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
        val name =etName.text.toString()
        val dob =etDateOfBirth.text.toString()
        val nationality =etNationality.text.toString()
        val idNo =etIdNumber.text.toString()
        val phone =etPhone.text.toString()
        val email =etEmailAddress.text.toString()
        var info =Info(name,dob,nationality,idNo,phone,email)
//        Toast.makeText(baseContext, details.toString(),Toast.LENGTH_LONG).show()
       }
    }
}
data class Info(
    var name:String,
    var dob:String,
    var id:String,
    var email:String,
    var nationality: String,
    var phone:String,
)
data class Courses(
    var courseName:String,
    var courseCode:String,
    var description:String,
    var instructor:String,

)