package com.example.csharplearningapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.csharplearningapp.ui.theme.AppBg
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star // Пример иконки сохранения
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.csharplearningapp.data.LessonData
import com.example.csharplearningapp.data.TheoryStep
import com.example.csharplearningapp.ui.theme.AppAccent
import com.example.csharplearningapp.ui.theme.AppAccent2
import com.example.csharplearningapp.ui.theme.AppBorder
import com.example.csharplearningapp.ui.theme.AppMuted
import com.example.csharplearningapp.ui.theme.AppSurface
import com.example.csharplearningapp.ui.theme.AppText
import com.example.csharplearningapp.ui.theme.CSharpLearningAppTheme
import com.example.csharplearningapp.ui.theme.SynFunc
import com.example.csharplearningapp.ui.theme.SynKeyword
import com.example.csharplearningapp.ui.theme.SynNumber
import com.example.csharplearningapp.ui.theme.SynString
import com.example.csharplearningapp.ui.theme.SynType


@Composable
fun DynamicTheoryScreen(
    lesson: LessonData,
    onBackClick: () -> Unit,
    onStartTestClick: () -> Unit
) {
    Scaffold(
        containerColor = AppBg,
        topBar = {
            TheoryTopBar(
                currentLesson = 3,
                totalLessons = 5,
                onBackClick = onBackClick,
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            // Базовый заголовок
            TheoryHeader(lesson.title, lesson.subtitle)
            Spacer(modifier = Modifier.height(24.dp))

            // Рендерим контент динамически
            lesson.steps.forEach { step ->
                when (step) {
                    is TheoryStep.Text -> {
                        LessonText(step.content)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    is TheoryStep.TextWithInlineCode -> {
                        LessonTextWithCode(step.code, step.text)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    is TheoryStep.BulletList -> {
                        step.items.forEachIndexed { index, item ->
                            TheoryListItem((index + 1).toString(), item.first, item.second)
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }
                    is TheoryStep.CodeSnippet -> {
                        CodeCard(step.lang, step.code)
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                    is TheoryStep.SubHeader -> {
                        TheoryHeader(title = step.title, description = "", titleSize = 22)
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            TheoryBottomBar(onStartTestClick = onStartTestClick)
        }
    }
}

@Composable
fun TheoryScreen(
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit,
    onStartTestClick: () -> Unit
) {
    Scaffold(
        containerColor = AppBg,
        topBar = {
            TheoryTopBar(
                currentLesson = 3,
                totalLessons = 5,
                onBackClick = onBackClick,
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            // Заголовок урока
            TheoryHeader(
                title = "Условия и ветвления",
                description = "Научим программу принимать решения в зависимости от входных данных."
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Раздел 1: if/else
            LessonText("Конструкция ")
            LessonTextWithCode("if-else", " позволяет выполнять разный код при разных условиях. Это основа любой логики.")

            Spacer(modifier = Modifier.height(16.dp))

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                TheoryListItem(
                    number = "1",
                    boldText = "if",
                    normalText = " — выполняется, если условие истинно (true)."
                )
                TheoryListItem(
                    number = "2",
                    boldText = "else if",
                    normalText = " — проверяется, если первый if оказался ложным (false)."
                )
                TheoryListItem(
                    number = "3",
                    boldText = "else",
                    normalText = " — блок по умолчанию. Сработает, если ни одно условие выше не подошло."
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Первый блок кода
            CodeCard(
                lang = "C# • Пример",
                codeText = buildIfElseCodeSnippet()
            )

            Spacer(modifier = Modifier.height(28.dp))

            // Раздел 2: switch
            TheoryHeader(
                title = "Оператор switch",
                description = "Если вам нужно проверить одну переменную на множество конкретных значений, удобнее использовать switch вместо десятка else if.",
                titleSize = 22
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Второй блок кода
            CodeCard(
                lang = "C# • Пример",
                codeText = buildSwitchCodeSnippet()
            )

            Spacer(modifier = Modifier.height(16.dp))

            TheoryBottomBar(onStartTestClick = onStartTestClick)

            // Отступ снизу, чтобы контент не перекрывался нижней панелью при максимальном скролле
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun TheoryTopBar(
    currentLesson: Int,
    totalLessons: Int,
    onBackClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Кнопка Назад
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .size(40.dp)
                .background(AppSurface, RoundedCornerShape(12.dp))
                .border(1.dp, AppBorder, RoundedCornerShape(12.dp))
        ) {
            Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Назад", tint = AppText)
        }

        // Номер урока
        Text(
            text = "УРОК $currentLesson ИЗ $totalLessons",
            color = AppMuted,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.05.sp
        )

        // Кнопка Сохранить
//        IconButton(
//            onClick = onSaveClick,
//            modifier = Modifier
//                .size(40.dp)
//                .background(AppSurface, RoundedCornerShape(12.dp))
//                .border(1.dp, AppBorder, RoundedCornerShape(12.dp))
//        ) {
//            Icon(Icons.Default.Star, contentDescription = "Сохранить", tint = AppText, modifier = Modifier.size(18.dp))
//        }
    }
}

@Composable
fun TheoryHeader(title: String, description: String, titleSize: Int = 28) {
    Column {
        Text(
            text = title,
            color = AppText,
            fontSize = titleSize.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = (-0.03).sp,
            lineHeight = 34.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = description,
            color = AppMuted,
            fontSize = 15.sp,
            lineHeight = 22.sp
        )
    }
}

@Composable
fun LessonText(text: String) {
    Text(text = text, color = Color(0xFFD0D3E0), fontSize = 15.sp, lineHeight = 24.sp)
}

@Composable
fun LessonTextWithCode(codePart: String, normalPart: String) {
    // Реализация инлайн кода как в HTML

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = AppAccent2, background = Color(0xFF222533), fontFamily = FontFamily.Monospace, fontSize = 13.sp)) {
            append(" $codePart ")
        }
        withStyle(style = SpanStyle(color = Color(0xFFD0D3E0), fontSize = 15.sp)) {
            append(normalPart)
        }
    }
    Text(text = annotatedString, lineHeight = 24.sp)
}

@Composable
fun TheoryListItem(number: String, boldText: String, normalText: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppSurface, RoundedCornerShape(14.dp))
            .border(1.dp, AppBorder, RoundedCornerShape(14.dp))
            .padding(14.dp),
        verticalAlignment = Alignment.Top
    ) {
        // Кастомный буллит с цифрой
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(AppAccent.copy(alpha = 0.15f), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = number,
                color = AppAccent2,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        // Текст элемента
        val itemText = buildAnnotatedString {
            withStyle(style = SpanStyle(color = AppAccent2, fontWeight = FontWeight.SemiBold)) {
                append(boldText)
            }
            withStyle(style = SpanStyle(color = Color(0xFFD0D3E0))) {
                append(normalText)
            }
        }
        Text(text = itemText, fontSize = 14.5.sp, lineHeight = 21.sp)
    }
}

@Composable
fun CodeCard(lang: String, codeText: AnnotatedString) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF090B10), RoundedCornerShape(16.dp))
            .border(1.dp, Color(0xFF252833), RoundedCornerShape(16.dp))
    ) {
        // Шапка блока кода
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(AppSurface, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .border(1.dp, AppBorder, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = lang,
                color = AppMuted,
                fontFamily = FontFamily.Monospace,
                fontSize = 11.sp,
                letterSpacing = 0.05.sp
            )
            IconButton(onClick = { /* Копирование в буфер */ }, modifier = Modifier.size(20.dp)) {
                Icon(Icons.Default.Add, contentDescription = "Копировать", tint = AppMuted, modifier = Modifier.size(14.dp))
            }
        }

        // Сам код с подсветкой
        Box(modifier = Modifier.padding(16.dp)) {
            Text(
                text = codeText,
                fontFamily = FontFamily.Monospace,
                fontSize = 13.sp,
                lineHeight = 20.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun TheoryBottomBar(onStartTestClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color.Transparent, AppBg.copy(alpha = 0.95f), AppBg),
                    startY = 0.0f,
                    endY = 100.0f
                )
            )
            .padding(start = 20.dp, end = 20.dp, bottom = 32.dp, top = 16.dp)
    ) {
        // Кнопка с градиентом
        val gradientBrush = Brush.linearGradient(
            colors = listOf(AppAccent, Color(0xFF9B5DFC), Color(0xFFC084FC))
        )

        Button(
            onClick = onStartTestClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(gradientBrush, RoundedCornerShape(18.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Пройти тест",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = (-0.01).sp
                )
            }
        }
    }
}

fun buildIfElseCodeSnippet() = buildAnnotatedString {
    // int age = 18;
    withStyle(SpanStyle(color = SynType)) { append("int") }
    append(" age = ")
    withStyle(SpanStyle(color = SynNumber)) { append("18") }
    append(";\n\n")

    // if (age >= 18)
    withStyle(SpanStyle(color = SynKeyword)) { append("if") }
    append(" (age >= ")
    withStyle(SpanStyle(color = SynNumber)) { append("18") }
    append(")\n{\n    Console.")
    withStyle(SpanStyle(color = SynFunc)) { append("WriteLine") }
    append("(")
    withStyle(SpanStyle(color = SynString)) { append("\"Доступ разрешен\"") }
    append(");\n}\n")

    // else
    withStyle(SpanStyle(color = SynKeyword)) { append("else") }
    append("\n{\n    Console.")
    withStyle(SpanStyle(color = SynFunc)) { append("WriteLine") }
    append("(")
    withStyle(SpanStyle(color = SynString)) { append("\"Доступ запрещен\"") }
    append(");\n}")
}

fun buildSwitchCodeSnippet() = buildAnnotatedString {
    withStyle(SpanStyle(color = SynType)) { append("int") }
    append(" day = ")
    withStyle(SpanStyle(color = SynNumber)) { append("3") }
    append(";\n\n")

    withStyle(SpanStyle(color = SynKeyword)) { append("switch") }
    append(" (day)\n{\n")

    // case 1
    withStyle(SpanStyle(color = SynKeyword)) { append("    case ") }
    withStyle(SpanStyle(color = SynNumber)) { append("1") }
    append(":\n        Console.")
    withStyle(SpanStyle(color = SynFunc)) { append("WriteLine") }
    append("(")
    withStyle(SpanStyle(color = SynString)) { append("\"Понедельник\"") }
    append(");\n        ")
    withStyle(SpanStyle(color = SynKeyword)) { append("break") }
    append(";\n")

    // case 3
    withStyle(SpanStyle(color = SynKeyword)) { append("    case ") }
    withStyle(SpanStyle(color = SynNumber)) { append("3") }
    append(":\n        Console.")
    withStyle(SpanStyle(color = SynFunc)) { append("WriteLine") }
    append("(")
    withStyle(SpanStyle(color = SynString)) { append("\"Среда\"") }
    append(");\n        ")
    withStyle(SpanStyle(color = SynKeyword)) { append("break") }
    append(";\n")

    // default
    withStyle(SpanStyle(color = SynKeyword)) { append("    default") }
    append(":\n        Console.")
    withStyle(SpanStyle(color = SynFunc)) { append("WriteLine") }
    append("(")
    withStyle(SpanStyle(color = SynString)) { append("\"Другой день\"") }
    append(");\n        ")
    withStyle(SpanStyle(color = SynKeyword)) { append("break") }
    append(";\n}")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TheoryPreview() {
    val lesson3 = LessonData(
        id = 3,
        title = "Условия и ветвления",
        subtitle = "Научим программу принимать решения в зависимости от входных данных.",
        steps = listOf(
            TheoryStep.Text("Конструкция if-else позволяет выполнять разный код при разных условиях. Это основа любой логики."),

            TheoryStep.BulletList(listOf(
                "if" to " — выполняется, если условие истинно (true).",
                "else if" to " — проверяется, если первый if оказался ложным (false).",
                "else" to " — блок по умолчанию. Сработает, если ни одно условие выше не подошло."
            )),

            TheoryStep.CodeSnippet(
                lang = "C# • Пример if-else",
                code = buildIfElseCodeSnippet()
            ),

            TheoryStep.SubHeader("Оператор switch"),

            TheoryStep.Text("Если вам нужно проверить одну переменную на множество конкретных значений, удобнее использовать switch вместо десятка else if."),

            TheoryStep.CodeSnippet(
                lang = "C# • Пример switch",
                code = buildSwitchCodeSnippet()
            )
        )
    )

    CSharpLearningAppTheme {
        DynamicTheoryScreen(onBackClick = {},
            lesson = lesson3,
            onStartTestClick = {})
    }
}