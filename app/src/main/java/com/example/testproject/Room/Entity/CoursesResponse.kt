package com.example.testproject.Room.Entity

import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("courses")
    val courses: List<Course>
)