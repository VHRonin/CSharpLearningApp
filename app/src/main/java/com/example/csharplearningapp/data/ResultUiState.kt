package com.example.csharplearningapp.data

data class ResultUiState(
    val score: Int,
    val totalQuestions: Int,
    val timeSpent: String, // например, "2:45"
    val title: String,    // например, "Отличная работа!"
    val description: String,
    val accuracyPercentage: Int
)
