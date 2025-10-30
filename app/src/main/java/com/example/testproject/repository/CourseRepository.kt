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
    fun getCoursesSortedByPublishDate(): Flow<List<Course>> = courseDao.getCoursesSortedByPublishDate()

    suspend fun refreshCourses() {
        try {
            val currentFavorites = withContext(Dispatchers.IO) {
                courseDao.getFavoriteCourses().first()
            }
            val favoriteIds = currentFavorites.map { it.id }.toSet()
            val response = apiService.getCourses()
            if (response.isSuccessful) {
                val courses = response.body()?.courses ?: emptyList()
                withContext(Dispatchers.IO) {
                    courseDao.deleteAll()
                    courses.forEach { course ->
                        val updatedCourse = course.copy(
                            hasLike = course.id in favoriteIds
                        )
                        courseDao.insert(updatedCourse)
                    }
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun toggleFavorite(courseId: Int) {
        withContext(Dispatchers.IO) {
            val allCourses = courseDao.getAllCourses().first()
            val course = allCourses.find { it.id == courseId }
            course?.let {
                val newFavoriteState = !it.hasLike
                courseDao.setFavorite(courseId, newFavoriteState)
            }
        }
    }
}