package com.example.csharplearningapp.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Quiz : Screen("quiz")
    data object Result : Screen("result")
    data object Theory : Screen("theory/{lessonId}"){
        fun createRoute(lessonId: Int) = "theory/$lessonId"
    }
}