package com.example.testproject.screens.view

import com.example.testproject.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testproject.assets.roboto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Auth(navController: NavHostController)
{
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFF151515))
    )
    {
        Box(
            modifier = Modifier
                .padding(start = 16.dp, top = 140.dp)
        )
        {
            Text(
                text = "Вход",
                fontSize = 28.sp,
                fontFamily = roboto,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                ),
                color = Color(0xFFF2F2F3),
                letterSpacing = 0.sp,
                lineHeight = 36.sp
            )
        }
        Box(
            modifier = Modifier
                .height(230.dp)
                .padding(horizontal = 16.dp)
                .padding(top = 28.dp)
        )
        {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Email",
                    fontSize = 16.sp,
                    fontFamily = roboto,
                    style = TextStyle(
                        fontWeight = FontWeight.Medium
                    ),
                    color = Color(0xFFF2F2F3),
                    letterSpacing = 0.15.sp,
                    lineHeight = 18.sp
                )
                TextField(
                    value = email.value,
                    onValueChange = { newText -> email.value = newText },
                    placeholder = {
                        Text(
                            "example@gmail.com",
                            fontSize = 14.sp,
                            fontFamily = roboto,
                            color = Color(0xFFF2F2F3).copy(alpha = 0.5f),
                            letterSpacing = 0.25.sp,
                            lineHeight = 20.sp
                            )
                    },
                    shape = RoundedCornerShape(30.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFF32333A),
                        unfocusedContainerColor = Color(0xFF32333A),
                        disabledContainerColor = Color(0xFF32333A),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        cursorColor = Color(0xFFF2F2F3)
                    ),
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = roboto,
                        color = Color(0xFFF2F2F3)
                    ),
                    modifier = Modifier
                        .heightIn(min = 40.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Пароль",
                    fontSize = 16.sp,
                    fontFamily = roboto,
                    style = TextStyle(
                        fontWeight = FontWeight.Medium
                    ),
                    color = Color(0xFFF2F2F3),
                    letterSpacing = 0.15.sp,
                    lineHeight = 18.sp
                )
                TextField(
                    value = password.value,
                    onValueChange = { newText -> email.value = newText },
                    placeholder = {
                        Text(
                            "Введите пароль",
                            fontSize = 14.sp,
                            fontFamily = roboto,
                            color = Color(0xFFF2F2F3).copy(alpha = 0.5f),
                            letterSpacing = 0.25.sp,
                            lineHeight = 20.sp
                            )
                    },
                    shape = RoundedCornerShape(30.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFF32333A),
                        unfocusedContainerColor = Color(0xFF32333A),
                        disabledContainerColor = Color(0xFF32333A),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        cursorColor = Color(0xFFF2F2F3)
                    ),
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = roboto,
                        color = Color(0xFFF2F2F3)
                    ),
                    modifier = Modifier
                        .heightIn(min = 40.dp)
                        .fillMaxWidth()
                )
            }
        }
        Button(
            onClick = {navController.navigate("Main")},
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(color = Color(0xFF12B956), shape = RoundedCornerShape(30.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text("Вход",
                color = Color(0xFFF2F2F3),
                fontFamily = roboto,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                style = TextStyle(
                fontWeight = FontWeight.Medium,
                    letterSpacing = 0.1.sp,
                    lineHeight = 20.sp
            ),)
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            val textStyle = TextStyle(
                fontSize = 12.sp,
                fontFamily = roboto,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.4.sp,
                lineHeight = 15.sp
            )

            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(bottom = 8.dp)) {
                Text("Нет аккаунта?", style = textStyle, color = Color(0xFFF2F2F3))
                Text(" Регистрация", style = textStyle, color = Color(0xFF12B956))
            }

            Text("Забыл пароль", style = textStyle, color = Color(0xFF12B956))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp)
                .height(1.dp)
                .background(color = Color(0xFF4D555E))
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(color = Color(0xFF2683ED), shape = RoundedCornerShape(30.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {}
                Image(
                    painter = painterResource(
                        id = R.drawable.vk
                    ),
                    contentDescription = "VK",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(width = 60.dp, height = 50.dp)
                        .align(Alignment.Center)
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color(0xFFF98509), Color(0xFFF95D00))
                            ),
                            shape = RoundedCornerShape(30.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {}
                Image(
                    painter = painterResource(
                        id = R.drawable.ok
                    ),
                    contentDescription = "OK",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(width = 60.dp, height = 50.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}