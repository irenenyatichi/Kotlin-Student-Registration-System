package com.example.registration.ui

import android.content.Context
import android.content.SharedPreferences
import com.example.registration.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.registration.Constants
import com.example.registration.databinding.CourseResponseListItemBinding
import com.example.registration.models.CoursesResponse
import com.example.registration.models.EnrolmentRequest
import com.example.registration.viewmodel.EnrolViewModel

class CoursesResponseAdapter (var courseResponse: List<CoursesResponse>): RecyclerView.Adapter<CoursesResponseViewHolder>(){
    private lateinit var enrolViewModel: EnrolViewModel
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesResponseViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.course_response_list_item, parent, false)
        return CoursesResponseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesResponseViewHolder, position: Int) {
        var courseList = courseResponse.get(position)
        holder.tvDateCreated.text = courseList.date_created
        holder.tvDateUpdated.text = courseList.date_updated
        holder.tvUpdatedBy.text = courseList.updated_by
        holder.tvCourseId.text = courseList.course_id
        holder.tvCoursename.text = courseList.course_name
        holder.tvCourseCode.text = courseList.course_code
        holder.tvCourseDescription.text = courseList.description
        holder.tvCreatedBy.text = courseList.created_by
        holder.tvActive.text = courseList.active.toString()
        holder.tvInstructor.text  = courseList.instructor
        holder.btnEnrol.setOnClickListener {
            sharedPreferences = sharedPreferences
            //(Constants.SHAREDPREFS, Context.MODE_PRIVATE)
            var studentId = sharedPreferences.edit()
            var courseId = sharedPreferences.edit()
            var enrolRequest = EnrolmentRequest(
                student_id = studentId.toString(),
                course_id = courseId.toString()
            )
            enrolViewModel.enrol("ACCESS_TOKEN")
        }
    }

    override fun getItemCount(): Int {
        return courseResponse.size
    }
}

class CoursesResponseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var tvDateCreated = itemView.findViewById<TextView>(R.id.tvDateCreated)
    var tvDateUpdated = itemView.findViewById<TextView>(R.id.tvDateUpdated)
    var tvUpdatedBy = itemView.findViewById<TextView>(R.id.tvUpdatedBy)
    var tvCourseId = itemView.findViewById<TextView>(R.id.tvCourseId)
    var tvCoursename = itemView.findViewById<TextView>(R.id.tvCoursename)
    var tvCourseCode = itemView.findViewById<TextView>(R.id.tvCourseCode)
    var tvCourseDescription = itemView.findViewById<TextView>(R.id.tvCourseDescription)
    var tvCreatedBy = itemView.findViewById<TextView>(R.id.tvCreatedBy)
    var tvActive = itemView.findViewById<TextView>(R.id.tvActive)
    var tvInstructor = itemView.findViewById<TextView>(R.id.tvInstructor)
    var btnEnrol = itemView.findViewById<Button>(R.id.btnEnrol)
}
