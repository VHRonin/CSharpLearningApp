package com.example.csharplearningapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.csharplearningapp.data.LessonData
import com.example.csharplearningapp.data.LessonsRepository
import com.example.csharplearningapp.data.TheoryStep
import com.example.csharplearningapp.navigation.AppNavHost
import com.example.csharplearningapp.navigation.Screen
import com.example.csharplearningapp.ui.theme.CSharpLearningAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            CSharpLearningAppTheme {
                AppNavHost(navController)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CSharpLearningAppTheme {
        CSharpLearningScreen(rememberNavController())
    }
}


@Composable
fun CSharpLearningScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val topics = LessonsRepository.topics

    Scaffold(modifier = Modifier
            .fillMaxSize()
        .background(Color(0xFF090B10))
        .statusBarsPadding()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF090B10))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(bottom = 100.dp) // место под кнопку
            ) {

                // Header
                HeaderSection()

                // Progress Card
                ProgressCard()

                // Topics Section
                TopicsSection(navController, topics)
            }

            // Bottom CTA
            BottomCTAButton(Modifier.align(Alignment.BottomCenter), navController)
        }
    }


}

// ==================== HEADER ====================
@Composable
private fun HeaderSection() {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Добро пожаловать 👋",
                fontSize = 13.sp,
                color = Color(0xFF7B82A0),
                fontWeight = FontWeight.Normal
            )
        }

        Spacer(Modifier.height(4.dp))

        Text(
            text = buildAnnotatedString {
                append("Изучение ")
                withStyle(
                    SpanStyle(
                        brush = Brush.horizontalGradient(
                            listOf(Color(0xFFA688FF), Color(0xFFC084FC))
                        )
                    )
                ) {
                    append("C#")
                }
            },
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = (-0.03).em,
            lineHeight = 32.sp,
            color = Color.White
        )
    }
}

// ==================== PROGRESS CARD ====================
@Composable
private fun ProgressCard() {
    val doneThemesCount = LessonsRepository.topics.count { it.isDone }
    val lessonDuration = 5
    val remainingTopics = LessonsRepository.topics.size - doneThemesCount
    val doneTopicsPercent = doneThemesCount / LessonsRepository.topics.size
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF141720)),
        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.07f))
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "ОБЩИЙ ПРОГРЕСС",
                fontSize = 12.sp,
                fontFamily = FontFamily.Monospace,
                letterSpacing = 0.08.em,
//                textTransform = TextTransform.Uppercase,
                color = Color(0xFF7B82A0)
            )

            Spacer(Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("${doneThemesCount} ")
                        withStyle(SpanStyle(fontSize = 18.sp, color = Color(0xFF7B82A0))) {
                            append("/ ${LessonsRepository.topics.size} тем")
                        }
                    },
                    fontSize = 36.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = (-0.04).em,
                    color = Color(0xFFE8EAF2)
                )

                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFF3ECF8E).copy(alpha = 0.15f),
                            shape = RoundedCornerShape(100.dp)
                        )
                        .border(1.dp, Color(0xFF3ECF8E).copy(alpha = 0.3f), RoundedCornerShape(100.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "${doneThemesCount / LessonsRepository.topics.size * 100}%",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Monospace,
                        color = Color(0xFF3ECF8E)
                    )
                }
            }

            Spacer(Modifier.height(14.dp))

            // Progress Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(Color(0xFF1C2030), RoundedCornerShape(100.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(if (doneTopicsPercent == 0) 0.05f else remainingTopics.toFloat())
                        .height(8.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(Color(0xFF7C5CFC), Color(0xFFC084FC))
                            ),
                            RoundedCornerShape(100.dp)
                        )
                        .shadow(12.dp, RoundedCornerShape(100.dp), spotColor = Color(0xFF7C5CFC))
                )
            }

            Spacer(Modifier.height(8.dp))

            Text(
                text = when (remainingTopics){
                    1 -> "Осталось ${remainingTopics} тема · ~${lessonDuration * remainingTopics} мин"
                    in 2..4 -> "Осталось ${remainingTopics} темы · ~${lessonDuration * remainingTopics} мин"
                    else -> "Осталось ${remainingTopics} тем · ~${lessonDuration * remainingTopics} мин"
                },
                fontSize = 12.sp,
                color = Color(0xFF7B82A0)
            )
        }
    }
}

// ==================== TOPICS ====================
@Composable
private fun TopicsSection(navController: NavController, topics: List<Topic>) {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Темы курса",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
//            Text(
//                text = "Все темы →",
//                fontSize = 12.sp,
//                fontWeight = FontWeight.Medium,
//                color = Color(0xFFA688FF)
//            )
        }

        topics.forEach { topic ->
            TopicCard(topic, navController)
            Spacer(Modifier.height(10.dp))
        }
    }
}

data class Topic(
    val lessonData: LessonData,
    val isDone: Boolean,
    val isActive: Boolean,
    val icon: Int
)

@Composable
private fun TopicCard(topic: Topic, navController: NavController) {
    val isDone = topic.isDone
    val isActive = topic.isActive

    Card(
        modifier = Modifier.fillMaxWidth().clickable{
            if (isActive || isDone) navController.navigate(Screen.Theory.createRoute(topic.lessonData.id))
        },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isActive) Color(0xFF1C2030) else Color(0xFF141720)
        ),
        border = BorderStroke(
            width = 1.dp,
            color = when {
                isDone -> Color(0xFF3ECF8E).copy(alpha = 0.2f)
                isActive -> Color(0xFF7C5CFC).copy(alpha = 0.4f)
                else -> Color.White.copy(alpha = 0.07f)
            }
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = if (isDone) Color(0xFF3ECF8E).copy(alpha = 0.12f)
                        else Color(0xFF1C2030),
                        shape = RoundedCornerShape(14.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(topic.icon),
                    contentDescription = null,
                    tint = if (isDone) Color(0xFF3ECF8E) else Color(0xFFA688FF),
                    modifier = Modifier.size(22.dp)
                )
            }

            Spacer(Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = topic.lessonData.title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = topic.lessonData.subtitle,
                    fontSize = 12.sp,
                    color = Color(0xFF7B82A0),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                val statusText = when {
                    isDone -> "ГОТОВО"
                    isActive -> "В ПРОЦЕССЕ"
                    else -> "🔒 ЗАКРЫТО"
                }

                val statusColor = when {
                    isDone -> Color(0xFF3ECF8E)
                    isActive -> Color(0xFFA688FF)
                    else -> Color(0xFF7B82A0)
                }

                Box(
                    modifier = Modifier
                        .background(
                            color = statusColor.copy(alpha = 0.12f),
                            shape = RoundedCornerShape(100.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = statusText,
                        fontSize = 10.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.SemiBold,
                        color = statusColor
                    )
                }

                Spacer(Modifier.height(6.dp))

                Icon(
                    painter = painterResource(R.drawable.ic_chevron_right),
                    contentDescription = null,
                    tint = Color(0xFF7B82A0).copy(alpha = 0.5f),
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

// ==================== BOTTOM BUTTON ====================
@Composable
private fun BottomCTAButton(modifier: Modifier = Modifier, navController: NavController) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color(0xFF090B10)),
                    startY = 0f,
                    endY = 120f
                )
            )
            .padding(horizontal = 20.dp, vertical = 32.dp)
    ) {
        Button(
            onClick = { navController.navigate(Screen.Quiz.route) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(0.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(Color(0xFF7C5CFC), Color(0xFF9B5DFC), Color(0xFFC084FC))
                        ),
                        shape = RoundedCornerShape(18.dp)
                    )
                    .padding(vertical = 17.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.ic_play),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(Modifier.width(10.dp))
                    Text(
                        text = "Начать тест",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}