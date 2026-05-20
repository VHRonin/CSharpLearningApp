package com.example.csharplearningapp.data

import androidx.compose.ui.text.buildAnnotatedString
import com.example.csharplearningapp.highlightSyntax

object QuizRepository {
    val lesson1Questions = listOf(

        QuizQuestion(
            id = 1,
            label = "Вопрос 1",
            text = "Какой тип данных используется для хранения целых чисел в C#?",

            options = listOf(
                QuizOption(
                    id = "a",
                    letter = "A",
                    text = "string"
                ),
                QuizOption(
                    id = "b",
                    letter = "B",
                    text = "bool"
                ),
                QuizOption(
                    id = "c",
                    letter = "C",
                    text = "int"
                ),
                QuizOption(
                    id = "d",
                    letter = "D",
                    text = "double"
                )
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Верно! Тип int используется для хранения целых чисел.",

            feedbackWrong =
                "Неверно. Для хранения целых чисел в C# используется тип int."
        ),

        QuizQuestion(
            id = 2,
            label = "Вопрос 2",
            text = "Что выведет следующий код?",

            codeSnippet = """
                int age = 18;
                Console.WriteLine(age);
                """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(
                    id = "a",
                    letter = "A",
                    text = "age"
                ),
                QuizOption(
                    id = "b",
                    letter = "B",
                    text = "18"
                ),
                QuizOption(
                    id = "c",
                    letter = "C",
                    text = "int"
                ),
                QuizOption(
                    id = "d",
                    letter = "D",
                    text = "Ошибка"
                )
            ),

            correctOptionId = "b",

            feedbackCorrect =
                "Правильно! В консоль будет выведено значение переменной age.",

            feedbackWrong =
                "Неверно. Console.WriteLine(age) выводит значение переменной, то есть 18."
        ),

        QuizQuestion(
            id = 3,
            label = "Вопрос 3",
            text = "Какой тип данных используется для хранения значений true/false?",

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "int"),
                QuizOption(id = "b", letter = "B", text = "string"),
                QuizOption(id = "c", letter = "C", text = "bool"),
                QuizOption(id = "d", letter = "D", text = "char")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Верно! Тип bool хранит логические значения: true или false.",

            feedbackWrong =
                "Неверно. Для логических значений в C# используется тип bool."
        ),

        QuizQuestion(
            id = 4,
            label = "Вопрос 4",
            text = "Что выведет следующий код?",

            codeSnippet = """
        string name = "Алиса";
        Console.WriteLine("Привет, " + name);
        """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "Привет, name"),
                QuizOption(id = "b", letter = "B", text = "Алиса"),
                QuizOption(id = "c", letter = "C", text = "Ошибка"),
                QuizOption(id = "d", letter = "D", text = "Привет, Алиса")
            ),

            correctOptionId = "d",

            feedbackCorrect =
                "Правильно! Оператор + объединяет строки, результат — «Привет, Алиса».",

            feedbackWrong =
                "Неверно. Оператор + соединяет строку \"Привет, \" и значение переменной name, то есть \"Алиса\"."
        ),

        QuizQuestion(
            id = 5,
            label = "Вопрос 5",
            text = "Какое из объявлений переменной написано правильно?",

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "int 2count = 10;"),
                QuizOption(id = "b", letter = "B", text = "int count = 10;"),
                QuizOption(id = "c", letter = "C", text = "count int = 10;"),
                QuizOption(id = "d", letter = "D", text = "int count;= 10")
            ),

            correctOptionId = "b",

            feedbackCorrect =
                "Верно! Правильный синтаксис: сначала тип, затем имя переменной, затем значение через =.",

            feedbackWrong =
                "Неверно. Правильный синтаксис объявления: тип, имя переменной и присвоение значения — int count = 10;"
        )
    )

    fun getQuizForLesson(lessonId: Int): List<QuizQuestion> {

        return when (lessonId) {

            1 -> lesson1Questions

            else -> emptyList()
        }
    }
}