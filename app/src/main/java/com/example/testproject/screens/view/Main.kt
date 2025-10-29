package com.example.testproject.screens.view

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testproject.R
import com.example.testproject.assets.roboto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(navController: NavHostController) {
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
                                        text = "4.9",
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
                                    text = "22 Мая 2024",
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
                                text = "Java-разработчик с нуля",
                                color = Color(0xFFF2F2F3),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                letterSpacing = 0.15.sp,
                                fontFamily = roboto,
                                lineHeight = 18.sp
                            )
                            Text(
                                text = "Освойте backend-разработку и программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
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
                                    text = "999 ₽",
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
}