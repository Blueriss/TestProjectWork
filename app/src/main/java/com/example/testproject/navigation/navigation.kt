package com.example.testproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testproject.screens.view.Auth
import com.example.testproject.screens.view.Favorite
import com.example.testproject.screens.view.Main

@Composable
fun navigation()
{
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "Auth")
    {
        composable("Auth"){
            Auth(navController)
        }
        composable("Main"){
            Main(navController)
        }
        composable ("Favorite"){
            Favorite(navController)
        }
    }
}