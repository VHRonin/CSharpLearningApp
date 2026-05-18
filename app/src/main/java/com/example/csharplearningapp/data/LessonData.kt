package com.example.csharplearningapp.data

data class LessonData(
    val id: Int,
    val title: String,
    val subtitle: String,
    val steps: List<TheoryStep>
)