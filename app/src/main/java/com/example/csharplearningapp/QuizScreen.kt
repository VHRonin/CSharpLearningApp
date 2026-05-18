package com.example.csharplearningapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.csharplearningapp.data.QuizOption
import com.example.csharplearningapp.data.QuizQuestion
import com.example.csharplearningapp.data.QuizUiState
import com.example.csharplearningapp.data.SelectionState
import com.example.csharplearningapp.ui.theme.AppAccent
import com.example.csharplearningapp.ui.theme.AppAccent2
import com.example.csharplearningapp.ui.theme.AppBg
import com.example.csharplearningapp.ui.theme.AppBorder
import com.example.csharplearningapp.ui.theme.AppMuted
import com.example.csharplearningapp.ui.theme.AppSurface
import com.example.csharplearningapp.ui.theme.AppSurface2
import com.example.csharplearningapp.ui.theme.AppText
import com.example.csharplearningapp.ui.theme.CSharpLearningAppTheme

@Composable
fun QuizScreen(
    state: QuizUiState,
    onOptionSelect: (String) -> Unit,
    onNextClick: () -> Unit
) {
    Scaffold(
        containerColor = AppBg,
        topBar = {
            QuizTopNav(
                current = state.currentQuestion.id,
                total = 5,
                time = state.timeLeft
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            QuizProgressDots(state.progress, state.currentQuestion.id - 1)

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                // Текст вопроса
                Text(
                    text = "ВОПРОС ${state.currentQuestion.id}",
                    color = AppAccent2,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = state.currentQuestion.text,
                    color = AppText,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 28.sp
                )

                // Код внутри вопроса (если есть)
                state.currentQuestion.codeSnippet?.let {
                    Spacer(modifier = Modifier.height(14.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF0A0C10), RoundedCornerShape(12.dp))
                            .border(1.dp, AppBorder, RoundedCornerShape(12.dp))
                            .padding(14.dp)
                    ) {
                        Text(text = it, fontFamily = FontFamily.Monospace, fontSize = 12.5.sp, lineHeight = 21.sp, color = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Варианты ответов
                state.currentQuestion.options.forEach { option ->
                    val selectionState = when {
                        state.isAnswered && option.id == state.currentQuestion.correctOptionId -> SelectionState.CORRECT
                        state.isAnswered && option.id == state.selectedOptionId -> SelectionState.WRONG
                        option.id == state.selectedOptionId -> SelectionState.SELECTED
                        else -> SelectionState.NONE
                    }

                    OptionCard(option, selectionState) { onOptionSelect(option.id) }
                    Spacer(modifier = Modifier.height(10.dp))
                }

                // Фидбек (появляется после ответа)
                AnimatedVisibility(visible = state.isAnswered) {
                    val isCorrect = state.selectedOptionId == state.currentQuestion.correctOptionId
                    FeedbackStrip(
                        isCorrect = isCorrect,
                        text = if (isCorrect) state.currentQuestion.feedbackCorrect else state.currentQuestion.feedbackWrong
                    )
                }
            }

            // Нижняя кнопка
            Box(modifier = Modifier.padding(20.dp).padding(bottom = 16.dp)) {
                AppMainButton(
                    text = "Далее",
                    enabled = state.selectedOptionId != null,
                    onClick = onNextClick
                )
            }
        }
    }
}

@Composable
fun AppMainButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: ImageVector = Icons.AutoMirrored.Filled.ArrowForward,
    onClick: () -> Unit
) {
    // Градиент из твоего CSS: linear-gradient(135deg, #7c5cfc 0%, #9b5dfc 50%, #c084fc 100%)
    val buttonGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF7C5CFC),
            Color(0xFF9B5DFC),
            Color(0xFFC084FC)
        )
    )

    // Тень из CSS: 0 8px 32px rgba(124,92,252,0.45)
    val shadowColor = Color(0xFF7C5CFC).copy(alpha = 0.45f)

    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            // Применяем тень только если кнопка активна
            .then(
                if (enabled) Modifier.shadow(
                    elevation = 16.dp,
                    shape = RoundedCornerShape(18.dp),
                    ambientColor = shadowColor,
                    spotColor = shadowColor
                ) else Modifier
            )
            .alpha(if (enabled) 1f else 0.35f), // Прозрачность для disabled состояния
        shape = RoundedCornerShape(18.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent, // Прозрачный, так как фон — градиент
            contentColor = Color.White,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.White
        ),
        contentPadding = PaddingValues() // Убираем дефолтные отступы для градиента
    ) {
        // Отрисовка градиентного фона внутри кнопки
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(buttonGradient),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = (-0.01).sp
                )

                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Composable
fun FeedbackStrip(isCorrect: Boolean, text: String) {
    val color = if (isCorrect) Color(0xFF3ECF8E) else Color(0xFFF06090)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .background(color.copy(alpha = 0.08f), RoundedCornerShape(14.dp))
            .border(1.dp, color.copy(alpha = 0.25f), RoundedCornerShape(14.dp))
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = if (isCorrect) "✅" else "❌", fontSize = 18.sp)
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(
                text = if (isCorrect) "Правильно!" else "Неверно",
                color = color,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
            Text(text = text, color = AppMuted, fontSize = 12.sp, lineHeight = 16.sp)
        }
    }
}
@Composable
fun QuizTopNav(
    current: Int,
    total: Int,
    time: String,
    onBackClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Кнопка Назад
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .size(36.dp)
                .background(AppSurface, RoundedCornerShape(11.dp))
                .border(1.dp, AppBorder, RoundedCornerShape(11.dp))
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "Назад",
                tint = AppText,
                modifier = Modifier.size(18.dp)
            )
        }

        // Счетчик вопросов (3 / 5)
        val counterText = buildAnnotatedString {
            withStyle(SpanStyle(color = AppText)) { append(current.toString()) }
            withStyle(SpanStyle(color = AppMuted)) { append(" / $total") }
        }
        Text(
            text = counterText,
            fontFamily = FontFamily.Monospace,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold
        )

        // Таймер с пульсирующей точкой
        Row(
            modifier = Modifier
                .background(AppSurface, RoundedCornerShape(11.dp))
                .border(1.dp, AppBorder, RoundedCornerShape(11.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            TimerDot()
            Text(
                text = time,
                color = AppMuted,
                fontFamily = FontFamily.Monospace,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun TimerDot() {
    // Анимация пульсации (прозрачность от 0.3 до 1.0)
    val infiniteTransition = rememberInfiniteTransition(label = "TimerPulse")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.3f,
        animationSpec = infiniteRepeatable(
            animation = tween(750, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "DotAlpha"
    )

    Box(
        modifier = Modifier
            .size(6.dp)
            .alpha(alpha)
            .clip(CircleShape)
            .background(Color(0xFF3ECF8E)) // Green
    )
}

@Composable
fun OptionCard(
    option: QuizOption,
    state: SelectionState,
    onClick: () -> Unit
) {
    val borderColor = when (state) {
        SelectionState.SELECTED -> AppAccent
        SelectionState.CORRECT -> Color(0xFF3ECF8E) // Green
        SelectionState.WRONG -> Color(0xFFF06090)   // Red
        else -> AppBorder
    }

    val bgColor = when (state) {
        SelectionState.SELECTED -> AppAccent.copy(alpha = 0.1f)
        SelectionState.CORRECT -> Color(0xFF3ECF8E).copy(alpha = 0.08f)
        SelectionState.WRONG -> Color(0xFFF06090).copy(alpha = 0.08f)
        else -> AppSurface
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(bgColor)
            .border(1.5.dp, borderColor, RoundedCornerShape(16.dp))
            .clickable(enabled = state == SelectionState.NONE || state == SelectionState.SELECTED) { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Буква (A, B, C...)
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(if (state != SelectionState.NONE && state != SelectionState.SELECTED) borderColor else AppSurface2),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = option.letter,
                color = if (state != SelectionState.NONE && state != SelectionState.SELECTED) Color.White else AppMuted,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )
        }

        Spacer(modifier = Modifier.width(13.dp))

        Text(
            text = option.text,
            color = AppText,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )

        // Иконка результата (Check/Cross)
        if (state == SelectionState.CORRECT || state == SelectionState.WRONG) {
            Icon(
                imageVector = if (state == SelectionState.CORRECT) Icons.Default.Check else Icons.Default.Close,
                contentDescription = null,
                tint = borderColor,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}


@Composable
fun QuizProgressDots(progress: List<Boolean>, currentIndex: Int) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        progress.forEachIndexed { index, isDone ->
            val color = when {
                index == currentIndex -> AppAccent
                isDone -> AppAccent.copy(alpha = 0.5f)
                else -> AppSurface2
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(4.dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuizPreview() {
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

        // Состояние: выбран правильный ответ (для тестирования FeedbackStrip)
        val correctState = QuizUiState(
            currentQuestion = question3,
            selectedOptionId = "opt_a",
            isAnswered = true,
            timeLeft = "0:28",
            progress = listOf(true, true, false, false, false)
        )

    CSharpLearningAppTheme {
        QuizScreen(
            state = unansweredState,
            onOptionSelect = {},
            onNextClick = {}
        )
    }
}
