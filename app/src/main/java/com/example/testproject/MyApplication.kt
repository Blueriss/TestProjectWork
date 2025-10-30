package com.example.testproject

import android.app.Application
import com.example.testproject.Room.DataBase.AppDatabase
import com.example.testproject.repository.CourseRepository
import com.example.testproject.retrofit.RetrofitClient


class MyApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
    val apiService by lazy { RetrofitClient.apiService }
    val repository by lazy {
        CourseRepository(apiService, database.courseDao())
    }

}