package com.example.studentregistration

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoursesActivity : AppCompatActivity(){
    lateinit var rvCourses:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        displayCourses()
    }
    fun displayCourses(){
        var coursesList = listOf(
            Courses("IOT","IO207","IOT for 21st Century Connectivity","Barre Yasin"),
            Courses("PD","IO207","IOT for 21st Century Connectivity","Barre Yasin"),
            Courses("JS","IO207","IOT for 21st Century Connectivity","Barre Yasin"),
            Courses("Python","IO207","IOT for 21st Century Connectivity","Barre Yasin"),
            Courses("Kotlin","IO207","IOT for 21st Century Connectivity","Barre Yasin"),
        )
        rvCourses = findViewById(R.id.rvCourse)
        var coursesAdapter = CoursesAdapter(coursesList)
//        rvCourses.layoutManager = LinearLayoutManager(baseContext)
//        rvCourses.adapter = coursesAdapter
//        Coz of the .apply we don't need these 2 lines above
        rvCourses.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = coursesAdapter
        }
    }
}