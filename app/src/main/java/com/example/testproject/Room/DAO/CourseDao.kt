package com.example.testproject.Room.DAO

import androidx.room.*
import com.example.testproject.Room.Entity.Course
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Query("SELECT * FROM courses")
    fun getAllCourses(): Flow<List<Course>>

    @Query("SELECT * FROM courses WHERE hasLike = true")
    fun getFavoriteCourses(): Flow<List<Course>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(course: Course): Long

    @Query("DELETE FROM courses")
    fun deleteAll(): Int

    @Query("SELECT * FROM courses ORDER BY publishDate DESC")
    fun getCoursesSortedByPublishDate(): Flow<List<Course>>

    @Query("UPDATE courses SET hasLike = :isFavorite WHERE id = :courseId")
    fun setFavorite(courseId: Int, isFavorite: Boolean)
}