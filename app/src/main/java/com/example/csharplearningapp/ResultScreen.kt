package com.example.csharplearningapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.csharplearningapp.data.ResultUiState
import com.example.csharplearningapp.ui.theme.AppAccent
import com.example.csharplearningapp.ui.theme.AppBg
import com.example.csharplearningapp.ui.theme.AppBorder
import com.example.csharplearningapp.ui.theme.AppMuted
import com.example.csharplearningapp.ui.theme.AppSurface
import com.example.csharplearningapp.ui.theme.AppText
import com.example.csharplearningapp.ui.theme.CSharpLearningAppTheme

@Composable
fun ResultScreen(
    state: ResultUiState,
    onRetryClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    Scaffold(containerColor = AppBg) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Визуальный результат
            ResultProgressCircle(state.score, state.totalQuestions)

            Spacer(modifier = Modifier.height(32.dp))

            // Текстовый фидбек
            Text(
                text = state.title,
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                color = AppText,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = state.description,
                fontSize = 15.sp,
                color = AppMuted,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Сетка статистики
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    StatCard("Точность", "${state.accuracyPercentage}%", Color(0xFF3ECF8E))
                }
                Box(modifier = Modifier.weight(1f)) {
                    StatCard("Время", "${state.timeSpent} мин")
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Кнопки действий
            AppMainButton(
                text = "Пройти снова",
                onClick = onRetryClick,
                icon = Icons.Outlined.Refresh
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Вспомогательная кнопка (Secondary)
            Button(
                onClick = onHomeClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = AppText
                ),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(1.dp, AppBorder)
            ) {
                Text("На главную", fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Composable
fun ResultProgressCircle(score: Int, total: Int) {
    val sweepAngle = (score.toFloat() / total.toFloat()) * 360f

    Box(
        modifier = Modifier
            .size(180.dp)
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        // Фоновый круг (путь)
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = AppSurface,
                style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round)
            )
            // Активная часть прогресса
            drawArc(
                color = AppAccent,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round)
            )
        }

        // Текст внутри
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = score.toString(),
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                text = "из $total",
                fontSize = 16.sp,
                fontFamily = FontFamily.Monospace,
                color = AppMuted
            )
        }
    }
}

@Composable
fun StatCard(label: String, value: String, valueColor: Color = AppText) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppSurface, RoundedCornerShape(20.dp))
            .border(1.dp, AppBorder, RoundedCornerShape(20.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label.uppercase(),
            fontSize = 11.sp,
            color = AppMuted,
            letterSpacing = 0.05.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = valueColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ResultPreview() {
    val mockResult = ResultUiState(
        score = 4,
        totalQuestions = 5,
        timeSpent = "2:45",
        title = "Отличная работа!",
        description = "Ты почти мастер в условиях C#. Еще пара повторений и теория будет отскакивать от зубов.",
        accuracyPercentage = 80
    )

    CSharpLearningAppTheme {
        ResultScreen(mockResult, {}, {})
    }
}