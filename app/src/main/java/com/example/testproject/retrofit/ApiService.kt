package com.example.testproject.retrofit

import com.example.testproject.Room.Entity.Course
import com.example.testproject.Room.Entity.CoursesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    suspend fun getCourses(): Response<CoursesResponse>
}