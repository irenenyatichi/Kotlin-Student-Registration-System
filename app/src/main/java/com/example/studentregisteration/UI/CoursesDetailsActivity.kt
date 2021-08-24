package com.example.registration.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.registration.R

class CourseDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)
        var btnCourseDetails = findViewById<Button>(R.id.btnCourseDetails)
        btnCourseDetails.setOnClickListener {
            var intent = Intent(baseContext, LogIn::class.java)
            startActivity(intent)
        }
    }
}
