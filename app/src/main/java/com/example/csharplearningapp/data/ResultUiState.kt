package com.example.csharplearningapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultUiState(
    val score: Int,
    val totalQuestions: Int,
    val timeSpent: String, // например, "2:45"
    val title: String,    // например, "Отличная работа!"
    val description: String,
    val accuracyPercentage: Int,
    val lessonId: Int
) : Parcelable
