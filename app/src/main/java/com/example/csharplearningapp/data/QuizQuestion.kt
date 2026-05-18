package com.example.csharplearningapp.data

import androidx.compose.ui.text.AnnotatedString

data class QuizQuestion(
    val id: Int,
    val label: String,
    val text: String,
    val codeSnippet: AnnotatedString? = null,
    val options: List<QuizOption>,
    val correctOptionId: String,
    val feedbackCorrect: String,
    val feedbackWrong: String
)
