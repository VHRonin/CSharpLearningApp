package com.example.csharplearningapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.csharplearningapp.CSharpLearningScreen
import com.example.csharplearningapp.DynamicTheoryScreen
import com.example.csharplearningapp.QuizScreen
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

@Composable
fun AppNavHost(navController: NavHostController){
    val question3 = QuizQuestion(
        id = 3,
        label = "Вопрос 3",
        text = "Что выведет программа?",
        codeSnippet = buildIfElseCodeSnippet(),
        options = listOf(
            QuizOption("opt_a", "A", "\"A\""),
            QuizOption("opt_b", "B", "\"B\""),
            QuizOption("opt_c", "C", "Ничего — ошибка компиляции"),
            QuizOption("opt_d", "D", "\"A\" и \"B\"")
        ),
        correctOptionId = "opt_a",
        feedbackCorrect = "x > 5 — истина, поэтому выполняется первая ветка",
        feedbackWrong = "Правильный ответ: \"A\" — условие x > 5 выполняется"
    )
    // Состояние: вопрос отображен, но ответ еще не выбран
    val unansweredState = QuizUiState(
        currentQuestion = question3,
        selectedOptionId = null,
        isAnswered = false,
        timeLeft = "0:42",
        progress = listOf(true, true, false, false, false) // Первые два урока пройдены
    )

    val mockResult = ResultUiState(
        score = 4,
        totalQuestions = 5,
        timeSpent = "2:45",
        title = "Отличная работа!",
        description = "Ты почти мастер в условиях C#. Еще пара повторений и теория будет отскакивать от зубов.",
        accuracyPercentage = 80
    )

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
        ){
        composable(route = Screen.Home.route) {
            CSharpLearningScreen(navController)
        }

        composable(route = Screen.Quiz.route) {
            QuizScreen(unansweredState, {}, {}, navController)
        }

        composable(route = Screen.Result.route) {
            ResultScreen(mockResult, onRetryClick = {navController.navigate(Screen.Result.route)}, onHomeClick = {navController.navigate(Screen.Home.route)})
        }

        composable(route = Screen.Theory.route) { backStackEntry ->

            val lessonId = backStackEntry.arguments?.getString("lessonId")?.toIntOrNull()

            val lesson = LessonsRepository.topics.firstOrNull{it.lessonData.id == lessonId}?.lessonData

            lesson?.let {
                DynamicTheoryScreen(
                    onBackClick = {navController.popBackStack()},
                    onStartTestClick = {navController.navigate(Screen.Quiz.route)},
                    lesson = it
                )
            }


        }
    }
}