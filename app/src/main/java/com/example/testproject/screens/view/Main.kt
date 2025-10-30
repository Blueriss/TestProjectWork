package com.example.testproject.screens.view

import CourseViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.testproject.MyApplication
import com.example.testproject.R
import com.example.testproject.assets.roboto
import com.example.testproject.screens.CourseCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(navController: NavHostController) {

    val context = LocalContext.current
    val app = context.applicationContext as MyApplication

    val viewModel: CourseViewModel = viewModel(
        factory = remember {
            object : ViewModelProvider.Factory {
                override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                    return CourseViewModel(app.repository) as T
                }
            }
        }
    )
    val courses by viewModel.courses.collectAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.refreshCourses()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF151515))
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 56.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = Color(0xFF24252A),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .height(56.dp)
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.search
                    ),
                    contentDescription = "search",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.CenterStart)
                        .padding(start = 10.dp)
                )
                Text(
                    text = "Search courses...",
                    fontSize = 14.sp,
                    fontFamily = roboto,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                    ),
                    color = Color(0xFFF2F2F3).copy(alpha = 0.5f),
                    letterSpacing = 0.25.sp,
                    lineHeight = 18.sp,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 55.dp)
                )
            }
            Box(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .background(
                        color = Color(0xFF24252A),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .size(size = 56.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.funnel),
                    contentDescription = "funnel",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(25.dp)
                        .align(Alignment.Center)
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "По дате добавления",
                fontSize = 14.sp,
                fontFamily = roboto,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                ),
                color = Color(0xFF12B956),
                letterSpacing = 0.1.sp,
                lineHeight = 20.sp
            )
            Image(
                painter = painterResource(id = R.drawable.arrow1),
                contentDescription = "arrow1",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(20.dp)
                    .padding(start = 3.dp)
            )
        }
            LazyColumn {
                items(courses) { course ->
                    CourseCard(course = course)
                    Spacer(Modifier.height(16.dp))
                }
            }
    }
}
