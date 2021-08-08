package com.example.studentregisteration.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registration.Course

class CoursesActivity : AppCompatActivity() {
    lateinit var rvCourses:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        displayCourses()
    }
    fun displayCourses(){
        var courseList= listOf(
            Course("IOT","T001","IOT for 21st Century connectivity","Barre Yassin"),
            Course("Javascript","T002","Vanilla and Nodejs","Purity Maina"),
            Course("Mobile Development","T003","Kotlin development","John Owuor"),
            Course("Python","T007","Intro to data science","James Mwai"),
            Course("UI/UX Design","8GHY","User Interface Experience","Eric Asiego")
        )
        rvCourses=findViewById(R.id.rvCourses)
        var coursesAdapter=CoursesAdapter(courseList)
        rvCourses.layoutManager=LinearLayoutManager(baseContext)
        rvCourses.adapter=coursesAdapter

//        rvCourses.apply {
//            layoutManager=LinearLayoutManager(baseContext)
//            adapter=coursesAdapter
//        }
    }
}