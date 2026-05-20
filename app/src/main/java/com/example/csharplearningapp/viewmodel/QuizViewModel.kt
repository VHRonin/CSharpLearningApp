package com.example.csharplearningapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.csharplearningapp.data.QuizRepository
import com.example.csharplearningapp.data.QuizSessionState
import com.example.csharplearningapp.data.QuizUiState
import com.example.csharplearningapp.data.ResultUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {

    private val questions =
        QuizRepository.getQuizForLesson(1)

    private val _state =
        MutableStateFlow(
            QuizSessionState(
                questions = questions
            )
        )

    val state = _state.asStateFlow()

    val uiState: StateFlow<QuizUiState> =
        state.map { session ->

            QuizUiState(

                currentQuestion =
                    session.questions[
                        session.currentQuestionIndex
                    ],

                selectedOptionId =
                    session.selectedOptionId,

                isAnswered =
                    session.isAnswered,

                progress =
                    List(session.questions.size) { index ->

                        index < session.currentQuestionIndex
                    }
            )

        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            QuizUiState(
                currentQuestion = questions.first(),
                progress = List(questions.size) { false }
            )
        )

    val resultUiState: StateFlow<ResultUiState> =
        state.map { session ->

            val totalQuestions =
                session.questions.size

            val score =
                session.correctAnswersCount

            val percentage =
                if (totalQuestions == 0)
                    0
                else
                    ((score.toFloat() / totalQuestions) * 100).toInt()

            ResultUiState(

                score = score,

                totalQuestions = totalQuestions,

                timeSpent = "2:45",

                accuracyPercentage = percentage,

                title = when {

                    percentage >= 80 ->
                        "Отличная работа!"

                    percentage >= 50 ->
                        "Хороший результат!"

                    else ->
                        "Нужно ещё немного практики"
                },

                description = when {

                    percentage == 100 ->
                        "Идеальный результат! Ты ответил правильно на все вопросы. Похоже, C# уже начинает становиться для тебя родным языком."

                    percentage >= 80 ->
                        "Ты почти мастер в условиях C#. Еще пара повторений и теория будет отскакивать от зубов."

                    percentage >= 50 ->
                        "Основы понятны, но стоит закрепить материал. Попробуй пройти урок ещё раз."

                    else ->
                        "Пока тема даётся непросто, но это нормально. Вернись к теории и попробуй пройти тест ещё раз"
                }
            )

        }.stateIn(
            viewModelScope,
            SharingStarted.Eagerly, // WhileSubscribed(5000)

            ResultUiState(
                score = 0,
                totalQuestions = 0,
                timeSpent = "0:00",
                title = "",
                description = "",
                accuracyPercentage = 0
            )
        )

    private val _navigationEvent = MutableSharedFlow<ResultUiState>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    fun selectOption(optionId: String) {

        if (_state.value.isAnswered) return

        _state.update {

            it.copy(
                selectedOptionId = optionId,
                isAnswered = true
            )
        }
    }

    fun nextQuestion() {

        val currentState = _state.value

        val currentQuestion =
            currentState.questions[
                currentState.currentQuestionIndex
            ]

        val isCorrect =
            currentState.selectedOptionId ==
                    currentQuestion.correctOptionId

        val newCorrectAnswersCount =
            if (isCorrect)
                currentState.correctAnswersCount + 1
            else
                currentState.correctAnswersCount

        val isLastQuestion =
            currentState.currentQuestionIndex ==
                    currentState.questions.lastIndex

        if (isLastQuestion) {

            _state.update {
                it.copy(
                    isQuizFinished = true,
                    correctAnswersCount = newCorrectAnswersCount
                )
            }

            viewModelScope.launch {
                _navigationEvent.emit(resultUiState.value)
            }
        } else {

            _state.update {

                it.copy(
                    currentQuestionIndex =
                        it.currentQuestionIndex + 1,

                    selectedOptionId = null,

                    isAnswered = false,

                    correctAnswersCount =
                        newCorrectAnswersCount
                )
            }
        }
    }
}