package com.example.testproject.repository

import com.example.testproject.Room.DAO.CourseDao
import com.example.testproject.Room.Entity.Course
import com.example.testproject.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext

class CourseRepository(
    private val apiService: ApiService,
    private val courseDao: CourseDao
) {
    fun getCourses(): Flow<List<Course>> = courseDao.getAllCourses()
    fun getFavoriteCourses(): Flow<List<Course>> = courseDao.getFavoriteCourses()

    suspend fun refreshCourses() {
        try {
            val response = apiService.getCourses()

            if (response.isSuccessful) {
                val courses = response.body()?.courses ?: emptyList()

                withContext(Dispatchers.IO) {
                    courseDao.deleteAll()
                    courses.forEach { course ->
                        courseDao.insert(course)
                    }
                }

            }
        } catch (e: Exception) {
            throw e
        }
    }
}