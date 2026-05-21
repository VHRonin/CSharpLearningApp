package com.example.csharplearningapp.data

data class QuizSessionState(

    val questions: List<QuizQuestion> = emptyList(),

    val currentQuestionIndex: Int = 0,

    val selectedOptionId: String? = null,

    val isAnswered: Boolean = false,

    val correctAnswersCount: Int = 0,
    val isQuizFinished: Boolean = false,
    val elapsedSeconds: Int = 0
)