package com.example.testproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproject.R
import com.example.testproject.Room.Entity.Course
import com.example.testproject.assets.roboto

@Composable
fun CourseCard(course: Course) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(236.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0xFF24252A),
                )
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .height(114.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.course),
                        contentDescription = "course",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Row(
                        modifier = Modifier
                            .padding(bottom = 4.dp, start = 10.dp)
                            .align(Alignment.BottomStart)
                    ) {
                        Box(
                            modifier = Modifier
                                .background(
                                    color = Color(0xFF32333A4D),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.star),
                                    contentDescription = "star",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier.size(12.dp)
                                )
                                Text(
                                    text = course.rate.toString(),
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal,
                                    letterSpacing = 0.4.sp,
                                    lineHeight = 14.sp
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .background(
                                    color = Color(0xFF32333A4D),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = course.publishDate,
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                letterSpacing = 0.4.sp,
                                lineHeight = 14.sp
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .padding(top = 8.dp, end = 8.dp)
                            .align(Alignment.TopEnd)
                            .background(
                                color = Color(0xFF32333A4D),
                                shape = RoundedCornerShape(50)
                            )
                            .size(28.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bookmark),
                            contentDescription = "bookmark",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(16.dp)
                                .align(Alignment.Center)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF24252A))
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = course.title,
                            color = Color(0xFFF2F2F3),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = 0.15.sp,
                            fontFamily = roboto,
                            lineHeight = 18.sp
                        )
                        Text(
                            text = course.text,
                            color = Color(0xFFF2F2F3).copy(alpha = 0.7f),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            letterSpacing = 0.4.sp,
                            fontFamily = roboto,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            lineHeight = 16.sp
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "${course.price.toInt()} ₽",
                                color = Color(0xFFF2F2F3),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                letterSpacing = 0.15.sp,
                                fontFamily = roboto,
                                lineHeight = 18.sp
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(3.dp)
                            ) {
                                Text(
                                    text = "Подробнее",
                                    color = Color(0xFF12B956),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    letterSpacing = 0.4.sp,
                                    fontFamily = roboto,
                                    lineHeight = 15.sp,
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.arrow),
                                    contentDescription = "arrow",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}