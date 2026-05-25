package com.example.csharplearningapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.csharplearningapp.CSharpLearningScreen
import com.example.csharplearningapp.DynamicTheoryScreen
import com.example.csharplearningapp.QuizRoute
import com.example.csharplearningapp.QuizScreen
import com.example.csharplearningapp.ResultRoute
import com.example.csharplearningapp.ResultScreen
import com.example.csharplearningapp.buildIfElseCodeSnippet
import com.example.csharplearningapp.buildSwitchCodeSnippet
import com.example.csharplearningapp.data.LessonData
import com.example.csharplearningapp.data.LessonsRepository
import com.example.csharplearningapp.data.QuizOption
import com.example.csharplearningapp.data.QuizQuestion
import com.example.csharplearningapp.data.QuizUiState
import com.example.csharplearningapp.data.ResultUiState
import com.example.csharplearningapp.data.TheoryStep
import com.example.csharplearningapp.highlightSyntax
import com.example.csharplearningapp.viewmodel.QuizViewModel

@Composable
fun AppNavHost(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
        ){
        composable(route = Screen.Home.route) {
            CSharpLearningScreen(navController)
        }

        composable(route = Screen.Quiz.route) { backStackEntry ->
            val lessonId = backStackEntry.arguments?.getString("lessonId")?.toIntOrNull()

            lessonId?.let {
                QuizRoute(navController, it)
            }
        }

        composable(route = Screen.Result.route) {
            ResultRoute(navController)
        }

        composable(route = Screen.Theory.route) { backStackEntry ->

            val lessonId = backStackEntry.arguments?.getString("lessonId")?.toIntOrNull()

            val lesson = LessonsRepository.topics.firstOrNull{it.lessonData.id == lessonId}?.lessonData

            lesson?.let {
                DynamicTheoryScreen(
                    onBackClick = {navController.popBackStack()},
                    onStartTestClick = {navController.navigate(Screen.Quiz.createRoute(lessonId ?: 1))},
                    lesson = it
                )
            }


        }
    }
}