package com.example.csharplearningapp.data

data class QuizUiState(
    val currentQuestion: QuizQuestion,
    val selectedOptionId: String? = null,
    val isAnswered: Boolean = false,
    val timeLeft: String = "0:42",
    val progress: List<Boolean> // true - выполнено, false - нет
)
