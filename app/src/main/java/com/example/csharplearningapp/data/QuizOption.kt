package com.example.csharplearningapp.data

data class QuizOption(
    val id: String,
    val letter: String,
    val text: String,
    val isCode: Boolean = false
)