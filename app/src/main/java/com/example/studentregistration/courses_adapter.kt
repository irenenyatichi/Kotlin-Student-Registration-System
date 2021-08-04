package com.example.studentregistration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class CoursesAdapter(var courseList: List<Courses>) : RecyclerView.Adapter<CoursesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_list_layout, parent, false)
        return CoursesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        var currentcourse = courseList.get(position)
        holder.tvcourseName.text = currentcourse.courseName
        holder.tvcourseCode.text = currentcourse.courseCode
        holder.tvdescription.text = currentcourse.description
        holder.tvinstructor.text = currentcourse.instructor
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}

class CoursesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvcourseName = itemView.findViewById<TextView>(R.id.tvcourseName)
    var tvcourseCode = itemView.findViewById<TextView>(R.id.tvcourseCode)
    var tvdescription = itemView.findViewById<TextView>(R.id.tvdescription)
    var tvinstructor = itemView.findViewById<TextView>(R.id.tvinstructor)
}