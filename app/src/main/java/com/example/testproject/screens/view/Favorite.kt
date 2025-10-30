package com.example.testproject.screens.view

import CourseViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.testproject.MyApplication
import com.example.testproject.screens.CourseCard

@Composable
fun Favorite(navController: NavHostController) {
    val context = LocalContext.current
    val app = context.applicationContext as MyApplication

    val viewModel: CourseViewModel = viewModel(
        factory = remember {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return CourseViewModel(app.repository) as T
                }
            }
        }
    )
    val favoriteCourses by viewModel.favoriteCourses.collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.refreshCourses()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF151515))
    ) {
        LazyColumn {
            items(favoriteCourses) { favoriteCourses ->
                CourseCard(
                    course = favoriteCourses,
                    onFavoriteClick = { courseId ->
                        viewModel.toggleFavorite(courseId)
                    }
                )
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}