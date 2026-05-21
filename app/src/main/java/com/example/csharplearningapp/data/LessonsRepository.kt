package com.example.csharplearningapp.data

import android.content.Context
import android.content.SharedPreferences
import com.example.csharplearningapp.R
import com.example.csharplearningapp.Topic
import com.example.csharplearningapp.highlightSyntax
import com.google.gson.Gson
import androidx.core.content.edit
import com.example.csharplearningapp.TopicProgress
import com.google.gson.reflect.TypeToken

object LessonsRepository {

    const val PROGRESS_PREFS = "progress_prefs"
    const val PROGRESS_KEY = "progress_key"
    val gson = Gson()
    private lateinit var sharedPreferences: SharedPreferences

    val lesson1 = LessonData(
        id = 1,
        title = "Переменные",
        subtitle = "Научимся хранить информацию в памяти программы.",
        steps = listOf(

            TheoryStep.Text(
                "Переменные используются для хранения данных. " +
                        "Каждая переменная имеет тип, который определяет, какие значения можно хранить."
            ),

            TheoryStep.SubHeader("Основные типы данных"),

            TheoryStep.BulletList(
                listOf(
                    "int" to " — целые числа.",
                    "double" to " — дробные числа.",
                    "string" to " — текст.",
                    "bool" to " — true или false."
                )
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Пример переменных",
                code = """
int age = 18;
double height = 1.82;
string name = "Alex";
bool isStudent = true;
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.SubHeader("Создание переменной"),

            TheoryStep.Text(
                "Чтобы создать переменную, нужно указать тип, имя и значение."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Объявление переменной",
                code = """
string city = "Amsterdam";
Console.WriteLine(city);
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.TextWithInlineCode(
                code = "Console.WriteLine()",
                text = " используется для вывода текста в консоль."
            )
        )
    )

    val lesson2 = LessonData(
        id = 2,
        title = "Ввод и вывод",
        subtitle = "Научимся получать данные от пользователя и выводить результат.",
        steps = listOf(

            TheoryStep.Text(
                "Программа может не только выводить информацию, но и получать данные от пользователя."
            ),

            TheoryStep.SubHeader("Вывод данных"),

            TheoryStep.CodeSnippet(
                lang = "C# • Вывод текста",
                code = """
Console.WriteLine("Привет, мир!");
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.Text(
                "Метод Console.WriteLine() выводит текст в консоль."
            ),

            TheoryStep.SubHeader("Ввод данных"),

            TheoryStep.CodeSnippet(
                lang = "C# • Ввод строки",
                code = """
string name = Console.ReadLine();
Console.WriteLine("Привет, " + name);
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.Text(
                "Console.ReadLine() считывает строку, введенную пользователем."
            ),

            TheoryStep.SubHeader("Преобразование типов"),

            TheoryStep.Text(
                "Иногда введенные данные нужно преобразовать в число."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Преобразование строки в число",
                code = """
string input = Console.ReadLine();
int age = int.Parse(input);

Console.WriteLine(age);
            """.trimIndent().highlightSyntax()
            )
        )
    )

    val lesson3 = LessonData(
        id = 3,
        title = "Условия",
        subtitle = "Научим программу принимать решения в зависимости от входных данных.",
        steps = listOf(

            TheoryStep.Text(
                "Условия позволяют программе принимать решения и выполнять разный код " +
                        "в зависимости от ситуации."
            ),

            TheoryStep.SubHeader("Конструкция if"),

            TheoryStep.Text(
                "Оператор if выполняет код только в том случае, если условие истинно."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Пример if",
                code = """
int age = 18;

if (age >= 18)
{
    Console.WriteLine("Доступ разрешен");
}
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.TextWithInlineCode(
                code = "age >= 18",
                text = " — это условие, которое возвращает true или false."
            ),

            TheoryStep.SubHeader("if-else"),

            TheoryStep.Text(
                "Блок else выполняется, если условие в if оказалось ложным."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Пример if-else",
                code = """
int temperature = 10;

if (temperature > 20)
{
    Console.WriteLine("Тепло");
}
else
{
    Console.WriteLine("Холодно");
}
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.SubHeader("else if"),

            TheoryStep.Text(
                "Конструкция else if позволяет проверять несколько условий подряд."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Несколько условий",
                code = """
int score = 85;

if (score >= 90)
{
    Console.WriteLine("Отлично");
}
else if (score >= 70)
{
    Console.WriteLine("Хорошо");
}
else
{
    Console.WriteLine("Попробуйте еще");
}
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.SubHeader("Оператор switch"),

            TheoryStep.Text(
                "switch удобно использовать, когда нужно сравнить одну переменную " +
                        "с несколькими конкретными значениями."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Пример switch",
                code = """
int day = 3;

switch (day)
{
    case 1:
        Console.WriteLine("Понедельник");
        break;

    case 3:
        Console.WriteLine("Среда");
        break;

    default:
        Console.WriteLine("Другой день");
        break;
}
            """.trimIndent().highlightSyntax()
            )
        )
    )

    val lesson4 = LessonData(
        id = 4,
        title = "Циклы",
        subtitle = "Автоматизируем повторяющиеся действия с помощью циклов.",
        steps = listOf(

            TheoryStep.Text(
                "Циклы позволяют выполнять один и тот же код несколько раз. " +
                        "Это удобно для перебора данных, повторения действий и автоматизации."
            ),

            TheoryStep.SubHeader("Основные виды циклов"),

            TheoryStep.BulletList(
                listOf(
                    "for" to " — используется, когда известно количество повторений.",
                    "while" to " — работает, пока условие истинно.",
                    "foreach" to " — перебирает элементы коллекции."
                )
            ),

            TheoryStep.SubHeader("Цикл for"),

            TheoryStep.Text(
                "Цикл for идеально подходит для счетчиков и повторений с фиксированным количеством шагов."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Пример for",
                code = """
for (int i = 0; i < 5; i++)
{
    Console.WriteLine(i);
}
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.TextWithInlineCode(
                code = "i++",
                text = " увеличивает значение переменной на 1 после каждой итерации."
            ),

            TheoryStep.SubHeader("Цикл while"),

            TheoryStep.Text(
                "while выполняется до тех пор, пока условие остается true."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Пример while",
                code = """
int count = 0;

while (count < 3)
{
    Console.WriteLine(count);
    count++;
}
            """.trimIndent().highlightSyntax()
            )
        )
    )

    val lesson5 = LessonData(
        id = 5,
        title = "Массивы",
        subtitle = "Научимся хранить несколько значений в одной переменной.",
        steps = listOf(

            TheoryStep.Text(
                "Массивы позволяют хранить набор данных одного типа. " +
                        "Каждый элемент массива имеет свой индекс."
            ),

            TheoryStep.SubHeader("Создание массива"),

            TheoryStep.CodeSnippet(
                lang = "C# • Создание массива",
                code = """
int[] numbers = { 1, 2, 3, 4, 5 };
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.Text(
                "Индексы массива начинаются с 0."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Доступ к элементу",
                code = """
Console.WriteLine(numbers[0]);
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.TextWithInlineCode(
                code = "numbers[0]",
                text = " возвращает первый элемент массива."
            ),

            TheoryStep.SubHeader("Перебор массива"),

            TheoryStep.Text(
                "Для перебора массива удобно использовать цикл foreach."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • foreach",
                code = """
string[] fruits = { "Apple", "Banana", "Orange" };

foreach (string fruit in fruits)
{
    Console.WriteLine(fruit);
}
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.SubHeader("List<T>"),

            TheoryStep.Text(
                "List<T> — это более гибкая версия массива с динамическим размером."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • List",
                code = """
List<string> names = new List<string>();

names.Add("Alex");
names.Add("Maria");

Console.WriteLine(names.Count);
            """.trimIndent().highlightSyntax()
            )
        )
    )

    val lesson6 = LessonData(
        id = 6,
        title = "Методы",
        subtitle = "Научимся разбивать программу на переиспользуемые части.",
        steps = listOf(

            TheoryStep.Text(
                "Методы позволяют группировать код в отдельные блоки. " +
                        "Это делает программу более удобной, читаемой и переиспользуемой."
            ),

            TheoryStep.SubHeader("Создание метода"),

            TheoryStep.Text(
                "Метод состоит из имени, параметров и тела."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Простой метод",
                code = """
static void SayHello()
{
    Console.WriteLine("Привет!");
}
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.TextWithInlineCode(
                code = "void",
                text = " означает, что метод ничего не возвращает."
            ),

            TheoryStep.SubHeader("Вызов метода"),

            TheoryStep.Text(
                "После создания метод можно вызвать по имени."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Вызов метода",
                code = """
SayHello();
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.SubHeader("Параметры"),

            TheoryStep.Text(
                "Методы могут принимать данные через параметры."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Метод с параметром",
                code = """
static void Greet(string name)
{
    Console.WriteLine("Привет, " + name);
}

Greet("Alex");
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.SubHeader("Возвращаемое значение"),

            TheoryStep.Text(
                "Метод может возвращать результат с помощью return."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • return",
                code = """
static int Sum(int a, int b)
{
    return a + b;
}

int result = Sum(5, 3);

Console.WriteLine(result);
            """.trimIndent().highlightSyntax()
            )
        )
    )

    val lesson7 = LessonData(
        id = 7,
        title = "Классы и объекты",
        subtitle = "Познакомимся с основами объектно-ориентированного программирования.",
        steps = listOf(

            TheoryStep.Text(
                "Класс — это шаблон для создания объектов. " +
                        "Объекты содержат данные и действия."
            ),

            TheoryStep.SubHeader("Создание класса"),

            TheoryStep.CodeSnippet(
                lang = "C# • Пример класса",
                code = """
class Person
{
    public string name;
    public int age;
}
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.Text(
                "Класс Person описывает человека с именем и возрастом."
            ),

            TheoryStep.SubHeader("Создание объекта"),

            TheoryStep.CodeSnippet(
                lang = "C# • Создание объекта",
                code = """
Person user = new Person();

user.name = "Alex";
user.age = 20;
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.TextWithInlineCode(
                code = "new",
                text = " используется для создания нового объекта."
            ),

            TheoryStep.SubHeader("Методы внутри класса"),

            TheoryStep.Text(
                "Классы могут содержать не только данные, но и методы."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • Метод класса",
                code = """
class Person
{
    public string name;

    public void SayHello()
    {
        Console.WriteLine("Привет, меня зовут " + name);
    }
}
            """.trimIndent().highlightSyntax()
            ),

            TheoryStep.SubHeader("Инкапсуляция"),

            TheoryStep.Text(
                "Инкапсуляция помогает скрывать внутреннюю реализацию объекта."
            ),

            TheoryStep.CodeSnippet(
                lang = "C# • private поле",
                code = """
class BankAccount
{
    private int balance = 1000;
}
            """.trimIndent().highlightSyntax()
            )
        )
    )



    var topicsProgress = listOf(
        TopicProgress(false, true),
        TopicProgress(false, false),
        TopicProgress(false, false),
        TopicProgress(false, false),
        TopicProgress(false, false),
        TopicProgress(false, false),
        TopicProgress(false, false),
    )
    var topics = listOf(
        Topic(lesson1, topicsProgress[0], R.drawable.ic_variables),
        Topic(lesson2, topicsProgress[1], R.drawable.ic_input_output),
        Topic(lesson3, topicsProgress[2], R.drawable.ic_conditions),
        Topic(lesson4, topicsProgress[3], R.drawable.ic_loops),
        Topic(lesson5, topicsProgress[4], R.drawable.ic_arrays),
        Topic(lesson6, topicsProgress[5], R.drawable.ic_methods),
        Topic(lesson7, topicsProgress[6], R.drawable.ic_classes)
    )

    fun completeTopic(lessonId: Int){
        topics[lessonId - 1].topicProgress.isDone = true
        topics[lessonId - 1].topicProgress.isActive = false
        if ((lessonId - 1) < topics.lastIndex) topics[lessonId].topicProgress.isActive = true
    }

    fun getActiveLesson(): Int{
        val activeTopic = topics.firstOrNull{ it.topicProgress.isActive }

        return topics.indexOf(activeTopic) + 1
    }

    fun loadProgress(context: Context){
        sharedPreferences = context.getSharedPreferences(PROGRESS_PREFS, Context.MODE_PRIVATE)

        val defaultValue = gson.toJson(topicsProgress)

        val topicsSaved = sharedPreferences.getString(PROGRESS_KEY, defaultValue)

        val type = object : TypeToken<List<TopicProgress>>() {}.type

        topicsProgress = gson.fromJson(topicsSaved, type)
        topics = updateTopics()
    }

    fun saveProgress(){
        val json = gson.toJson(topicsProgress)

        sharedPreferences.edit {
            putString(PROGRESS_KEY, json)
        }
    }

    fun updateTopics(): List<Topic>{
        return listOf(
            Topic(lesson1, topicsProgress[0], R.drawable.ic_variables),
            Topic(lesson2, topicsProgress[1], R.drawable.ic_input_output),
            Topic(lesson3, topicsProgress[2], R.drawable.ic_conditions),
            Topic(lesson4, topicsProgress[3], R.drawable.ic_loops),
            Topic(lesson5, topicsProgress[4], R.drawable.ic_arrays),
            Topic(lesson6, topicsProgress[5], R.drawable.ic_methods),
            Topic(lesson7, topicsProgress[6], R.drawable.ic_classes)
        )
    }
}