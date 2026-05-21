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
        ),
    )

    val lesson2Questions = listOf(

        QuizQuestion(
            id = 1,
            label = "Вопрос 1",
            text = "Какой метод используется для вывода текста в консоль с переносом строки?",

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "Console.Write()"),
                QuizOption(id = "b", letter = "B", text = "Console.WriteLine()"),
                QuizOption(id = "c", letter = "C", text = "Console.Print()"),
                QuizOption(id = "d", letter = "D", text = "Console.Output()")
            ),

            correctOptionId = "b",

            feedbackCorrect =
                "Верно! Console.WriteLine() выводит текст и автоматически добавляет перенос строки.",

            feedbackWrong =
                "Неверно. Для вывода с переносом строки используется Console.WriteLine()."
        ),

        QuizQuestion(
            id = 2,
            label = "Вопрос 2",
            text = "Какой метод используется для считывания строки, введённой пользователем?",

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "Console.Write()"),
                QuizOption(id = "b", letter = "B", text = "Console.Scan()"),
                QuizOption(id = "c", letter = "C", text = "Console.ReadLine()"),
                QuizOption(id = "d", letter = "D", text = "Console.Input()")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Правильно! Console.ReadLine() считывает строку, которую ввёл пользователь.",

            feedbackWrong =
                "Неверно. Для считывания пользовательского ввода используется Console.ReadLine()."
        ),

        QuizQuestion(
            id = 3,
            label = "Вопрос 3",
            text = "Что выведет следующий код?",

            codeSnippet = """
            Console.Write("Привет, ");
            Console.Write("мир!");
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "Привет,\nмир!"),
                QuizOption(id = "b", letter = "B", text = "Привет, мир!"),
                QuizOption(id = "c", letter = "C", text = "Привет, \nмир!"),
                QuizOption(id = "d", letter = "D", text = "Ошибка")
            ),

            correctOptionId = "b",

            feedbackCorrect =
                "Верно! Console.Write() не добавляет перенос строки, поэтому текст выводится на одной строке.",

            feedbackWrong =
                "Неверно. Console.Write() выводит текст без переноса, поэтому оба вызова окажутся на одной строке: «Привет, мир!»."
        ),

        QuizQuestion(
            id = 4,
            label = "Вопрос 4",
            text = "Что выведет следующий код?",

            codeSnippet = """
            string name = Console.ReadLine();
            Console.WriteLine("Вас зовут: " + name);
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "Вас зовут: name"),
                QuizOption(id = "b", letter = "B", text = "Ошибка компиляции"),
                QuizOption(id = "c", letter = "C", text = "Вас зовут: [то, что ввёл пользователь]"),
                QuizOption(id = "d", letter = "D", text = "Console.ReadLine()")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Правильно! Console.ReadLine() сохраняет введённую строку в name, после чего она подставляется в вывод.",

            feedbackWrong =
                "Неверно. Console.ReadLine() возвращает введённую пользователем строку, которая затем выводится через WriteLine."
        ),

        QuizQuestion(
            id = 5,
            label = "Вопрос 5",
            text = "Как считать число, введённое пользователем, и сохранить его в переменную типа int?",

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "int n = Console.ReadLine();"),
                QuizOption(id = "b", letter = "B", text = "int n = int.Parse(Console.ReadLine());"),
                QuizOption(id = "c", letter = "C", text = "int n = Console.ReadInt();"),
                QuizOption(id = "d", letter = "D", text = "int n = Convert.ReadLine();")
            ),

            correctOptionId = "b",
            feedbackCorrect =
                "Верно! Console.ReadLine() возвращает строку, поэтому её нужно преобразовать в int с помощью int.Parse().",

            feedbackWrong =
                "Неверно. Console.ReadLine() возвращает string, а не int. Для преобразования используется int.Parse(Console.ReadLine())."
        )
    )

    val lesson3Questions = listOf(

        QuizQuestion(
            id = 1,
            label = "Вопрос 1",
            text = "Какой оператор используется для проверки условия в C#?",

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "for"),
                QuizOption(id = "b", letter = "B", text = "if"),
                QuizOption(id = "c", letter = "C", text = "switch"),
                QuizOption(id = "d", letter = "D", text = "while")
            ),

            correctOptionId = "b",

            feedbackCorrect =
                "Верно! Оператор if проверяет условие и выполняет блок кода, если оно истинно.",

            feedbackWrong =
                "Неверно. Для проверки условия используется оператор if."
        ),

        QuizQuestion(
            id = 2,
            label = "Вопрос 2",
            text = "Что выведет следующий код?",

            codeSnippet = """
            int x = 10;
            if (x > 5)
            {
                Console.WriteLine("Больше");
            }
            else
            {
                Console.WriteLine("Меньше");
            }
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "Меньше"),
                QuizOption(id = "b", letter = "B", text = "Больше"),
                QuizOption(id = "c", letter = "C", text = "10"),
                QuizOption(id = "d", letter = "D", text = "Ошибка")
            ),

            correctOptionId = "b",

            feedbackCorrect =
                "Правильно! Значение x равно 10, условие 10 > 5 истинно, поэтому выводится «Больше».",

            feedbackWrong =
                "Неверно. Условие x > 5 истинно (10 > 5), поэтому выполняется блок if и выводится «Больше»."
        ),

        QuizQuestion(
            id = 3,
            label = "Вопрос 3",
            text = "Что выведет следующий код?",

            codeSnippet = """
            int age = 15;
            if (age >= 18)
            {
                Console.WriteLine("Совершеннолетний");
            }
            else if (age >= 14)
            {
                Console.WriteLine("Подросток");
            }
            else
            {
                Console.WriteLine("Ребёнок");
            }
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "Совершеннолетний"),
                QuizOption(id = "b", letter = "B", text = "Ребёнок"),
                QuizOption(id = "c", letter = "C", text = "Подросток"),
                QuizOption(id = "d", letter = "D", text = "Ошибка")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Верно! age = 15, первое условие (>= 18) ложно, второе (>= 14) — истинно, поэтому выводится «Подросток».",

            feedbackWrong =
                "Неверно. Первое условие age >= 18 ложно, но второе age >= 14 истинно (15 >= 14), поэтому выводится «Подросток»."
        ),

        QuizQuestion(
            id = 4,
            label = "Вопрос 4",
            text = "Какой оператор сравнения проверяет равенство двух значений в C#?",

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "="),
                QuizOption(id = "b", letter = "B", text = "!="),
                QuizOption(id = "c", letter = "C", text = "=>"),
                QuizOption(id = "d", letter = "D", text = "==")
            ),

            correctOptionId = "d",

            feedbackCorrect =
                "Правильно! Оператор == проверяет равенство, тогда как = используется для присвоения значения.",

            feedbackWrong =
                "Неверно. Для проверки равенства используется ==. Одиночный = — это присвоение, а не сравнение."
        ),

        QuizQuestion(
            id = 5,
            label = "Вопрос 5",
            text = "Что выведет следующий код?",

            codeSnippet = """
            int score = 70;
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
                Console.WriteLine("Удовлетворительно");
            }
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "Отлично"),
                QuizOption(id = "b", letter = "B", text = "Удовлетворительно"),
                QuizOption(id = "c", letter = "C", text = "Хорошо"),
                QuizOption(id = "d", letter = "D", text = "Ничего не выведет")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Верно! score = 70, первое условие (>= 90) ложно, второе (>= 70) истинно, поэтому выводится «Хорошо».",

            feedbackWrong =
                "Неверно. Условие score >= 90 ложно, но score >= 70 истинно (70 >= 70), поэтому выводится «Хорошо»."
        )
    )

    val lesson4Questions = listOf(

        QuizQuestion(
            id = 1,
            label = "Вопрос 1",
            text = "Какой цикл выполняется, пока условие истинно?",

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "for"),
                QuizOption(id = "b", letter = "B", text = "foreach"),
                QuizOption(id = "c", letter = "C", text = "while"),
                QuizOption(id = "d", letter = "D", text = "do")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Верно! Цикл while проверяет условие перед каждой итерацией и выполняется, пока оно истинно.",

            feedbackWrong =
                "Неверно. Цикл while выполняется, пока его условие истинно, проверяя его перед каждой итерацией."
        ),

        QuizQuestion(
            id = 2,
            label = "Вопрос 2",
            text = "Что выведет следующий код?",

            codeSnippet = """
            for (int i = 0; i < 3; i++)
            {
                Console.WriteLine(i);
            }
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "0\n1\n2\n3"),
                QuizOption(id = "b", letter = "B", text = "1\n2\n3"),
                QuizOption(id = "c", letter = "C", text = "0\n1\n2"),
                QuizOption(id = "d", letter = "D", text = "Ошибка")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Правильно! Переменная i начинается с 0 и увеличивается, пока i < 3, поэтому выводятся числа 0, 1, 2.",

            feedbackWrong =
                "Неверно. Цикл начинается с i = 0 и завершается, когда i достигает 3 (не включая его), выводя 0, 1, 2."
        ),

        QuizQuestion(
            id = 3,
            label = "Вопрос 3",
            text = "В чём отличие цикла do-while от цикла while?",

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "do-while быстрее работает"),
                QuizOption(id = "b", letter = "B", text = "do-while выполняет тело цикла хотя бы один раз"),
                QuizOption(id = "c", letter = "C", text = "do-while не требует условия"),
                QuizOption(id = "d", letter = "D", text = "do-while используется только с числами")
            ),

            correctOptionId = "b",

            feedbackCorrect =
                "Верно! В do-while тело цикла выполняется сначала, и лишь потом проверяется условие — поэтому минимум одна итерация гарантирована.",

            feedbackWrong =
                "Неверно. Главное отличие do-while в том, что тело цикла выполняется до проверки условия, то есть всегда хотя бы один раз."
        ),

        QuizQuestion(
            id = 4,
            label = "Вопрос 4",
            text = "Что выведет следующий код?",

            codeSnippet = """
            int i = 0;
            while (i < 5)
            {
                if (i == 3)
                {
                    break;
                }
                Console.WriteLine(i);
                i++;
            }
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "0\n1\n2\n3"),
                QuizOption(id = "b", letter = "B", text = "0\n1\n2\n3\n4"),
                QuizOption(id = "c", letter = "C", text = "0\n1\n2"),
                QuizOption(id = "d", letter = "D", text = "Ошибка")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Правильно! Когда i становится равным 3, выполняется break и цикл завершается. До этого успевают вывестись 0, 1, 2.",

            feedbackWrong =
                "Неверно. Оператор break прерывает цикл в момент, когда i == 3, поэтому число 3 уже не выводится. Результат: 0, 1, 2."
        ),

        QuizQuestion(
            id = 5,
            label = "Вопрос 5",
            text = "Что выведет следующий код?",

            codeSnippet = """
            for (int i = 0; i < 5; i++)
            {
                if (i == 2)
                {
                    continue;
                }
                Console.WriteLine(i);
            }
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "0\n1\n2\n3\n4"),
                QuizOption(id = "b", letter = "B", text = "0\n1\n3\n4"),
                QuizOption(id = "c", letter = "C", text = "0\n1"),
                QuizOption(id = "d", letter = "D", text = "2\n3\n4")
            ),

            correctOptionId = "b",

            feedbackCorrect =
                "Верно! Оператор continue пропускает текущую итерацию при i == 2, поэтому число 2 не выводится, но цикл продолжается дальше.",

            feedbackWrong =
                "Неверно. Оператор continue не завершает цикл, а лишь пропускает текущую итерацию. При i == 2 вывод пропускается, остальные числа (0, 1, 3, 4) выводятся."
        )
    )

    val lesson5Questions = listOf(

        QuizQuestion(
            id = 1,
            label = "Вопрос 1",
            text = "Как правильно объявить массив из 5 целых чисел в C#?",

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "int[] nums = new int[5];"),
                QuizOption(id = "b", letter = "B", text = "int nums = new int[5];"),
                QuizOption(id = "c", letter = "C", text = "int[] nums = int[5];"),
                QuizOption(id = "d", letter = "D", text = "array<int> nums = new array(5);")
            ),

            correctOptionId = "a",

            feedbackCorrect =
                "Верно! Массив объявляется с помощью квадратных скобок после типа и создаётся через new int[5].",

            feedbackWrong =
                "Неверно. Правильный синтаксис объявления массива: int[] nums = new int[5];"
        ),

        QuizQuestion(
            id = 2,
            label = "Вопрос 2",
            text = "Что выведет следующий код?",

            codeSnippet = """
            int[] nums = { 10, 20, 30, 40, 50 };
            Console.WriteLine(nums[2]);
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "10"),
                QuizOption(id = "b", letter = "B", text = "20"),
                QuizOption(id = "c", letter = "C", text = "30"),
                QuizOption(id = "d", letter = "D", text = "Ошибка")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Правильно! Индексация массивов начинается с 0, поэтому nums[2] — это третий элемент, то есть 30.",

            feedbackWrong =
                "Неверно. Индексы массива начинаются с 0: nums[0] = 10, nums[1] = 20, nums[2] = 30."
        ),

        QuizQuestion(
            id = 3,
            label = "Вопрос 3",
            text = "Что выведет следующий код?",

            codeSnippet = """
            int[] nums = { 5, 10, 15 };
            Console.WriteLine(nums.Length);
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "2"),
                QuizOption(id = "b", letter = "B", text = "15"),
                QuizOption(id = "c", letter = "C", text = "Ошибка"),
                QuizOption(id = "d", letter = "D", text = "3")
            ),

            correctOptionId = "d",

            feedbackCorrect =
                "Верно! Свойство Length возвращает количество элементов в массиве. В массиве три элемента, поэтому выводится 3.",

            feedbackWrong =
                "Неверно. Свойство Length возвращает именно количество элементов, а не последний индекс. Здесь элементов 3."
        ),

        QuizQuestion(
            id = 4,
            label = "Вопрос 4",
            text = "Что выведет следующий код?",

            codeSnippet = """
            int[] nums = { 3, 7, 1, 9, 4 };
            int sum = 0;
            foreach (int n in nums)
            {
                sum += n;
            }
            Console.WriteLine(sum);
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "9"),
                QuizOption(id = "b", letter = "B", text = "3"),
                QuizOption(id = "c", letter = "C", text = "24"),
                QuizOption(id = "d", letter = "D", text = "Ошибка")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Правильно! Цикл foreach перебирает все элементы массива и накапливает сумму: 3 + 7 + 1 + 9 + 4 = 24.",

            feedbackWrong =
                "Неверно. foreach поочерёдно прибавляет каждый элемент к sum: 3 + 7 + 1 + 9 + 4 = 24."
        ),

        QuizQuestion(
            id = 5,
            label = "Вопрос 5",
            text = "Что произойдёт при выполнении следующего кода?",

            codeSnippet = """
            int[] nums = { 1, 2, 3 };
            Console.WriteLine(nums[5]);
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "Выведет 0"),
                QuizOption(id = "b", letter = "B", text = "Выведет 3"),
                QuizOption(id = "c", letter = "C", text = "Ошибка выполнения: выход за пределы массива"),
                QuizOption(id = "d", letter = "D", text = "Ошибка компиляции")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Верно! Обращение к индексу за пределами массива вызывает IndexOutOfRangeException во время выполнения программы.",

            feedbackWrong =
                "Неверно. Код скомпилируется, но при выполнении выбросит исключение IndexOutOfRangeException — массив содержит только индексы 0, 1 и 2."
        )
    )

    val lesson6Questions = listOf(

        QuizQuestion(
            id = 1,
            label = "Вопрос 1",
            text = "Какое ключевое слово используется, если метод ничего не возвращает?",

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "null"),
                QuizOption(id = "b", letter = "B", text = "void"),
                QuizOption(id = "c", letter = "C", text = "empty"),
                QuizOption(id = "d", letter = "D", text = "none")
            ),

            correctOptionId = "b",

            feedbackCorrect =
                "Верно! Ключевое слово void указывает, что метод не возвращает никакого значения.",

            feedbackWrong =
                "Неверно. Если метод ничего не возвращает, его возвращаемый тип указывается как void."
        ),

        QuizQuestion(
            id = 2,
            label = "Вопрос 2",
            text = "Что выведет следующий код?",

            codeSnippet = """
            void Greet(string name)
            {
                Console.WriteLine("Привет, " + name + "!");
            }
            
            Greet("Алиса");
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "name"),
                QuizOption(id = "b", letter = "B", text = "Привет, name!"),
                QuizOption(id = "c", letter = "C", text = "Привет, Алиса!"),
                QuizOption(id = "d", letter = "D", text = "Ошибка")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Правильно! При вызове Greet(\"Алиса\") параметр name получает значение \"Алиса\", и в консоль выводится «Привет, Алиса!».",

            feedbackWrong =
                "Неверно. Строка \"Алиса\" передаётся как аргумент в параметр name, поэтому метод выведет «Привет, Алиса!»."
        ),

        QuizQuestion(
            id = 3,
            label = "Вопрос 3",
            text = "Что выведет следующий код?",

            codeSnippet = """
            int Add(int a, int b)
            {
                return a + b;
            }
            
            int result = Add(3, 7);
            Console.WriteLine(result);
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "3"),
                QuizOption(id = "b", letter = "B", text = "7"),
                QuizOption(id = "c", letter = "C", text = "37"),
                QuizOption(id = "d", letter = "D", text = "10")
            ),

            correctOptionId = "d",

            feedbackCorrect =
                "Верно! Метод Add принимает два числа и возвращает их сумму. Add(3, 7) возвращает 10, которое затем выводится.",

            feedbackWrong =
                "Неверно. Метод Add возвращает сумму двух аргументов: 3 + 7 = 10. Именно это значение сохраняется в result и выводится."
        ),

        QuizQuestion(
            id = 4,
            label = "Вопрос 4",
            text = "Что выведет следующий код?",

            codeSnippet = """
            int Square(int n)
            {
                return n * n;
            }
            
            Console.WriteLine(Square(4));
            Console.WriteLine(Square(3));
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "8\n6"),
                QuizOption(id = "b", letter = "B", text = "16\n9"),
                QuizOption(id = "c", letter = "C", text = "4\n3"),
                QuizOption(id = "d", letter = "D", text = "Ошибка")
            ),

            correctOptionId = "b",

            feedbackCorrect =
                "Правильно! Square(4) возвращает 4 * 4 = 16, Square(3) возвращает 3 * 3 = 9. Метод можно вызывать многократно с разными аргументами.",

            feedbackWrong =
                "Неверно. Метод возвращает квадрат числа: 4 * 4 = 16, 3 * 3 = 9. Именно эти значения и выводятся."
        ),

        QuizQuestion(
            id = 5,
            label = "Вопрос 5",
            text = "Что выведет следующий код?",

            codeSnippet = """
            int Max(int a, int b)
            {
                if (a > b)
                {
                    return a;
                }
                return b;
            }
            
            Console.WriteLine(Max(5, 12));
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "5"),
                QuizOption(id = "b", letter = "B", text = "12"),
                QuizOption(id = "c", letter = "C", text = "17"),
                QuizOption(id = "d", letter = "D", text = "Ошибка")
            ),

            correctOptionId = "b",

            feedbackCorrect =
                "Верно! Условие 5 > 12 ложно, поэтому первый return пропускается и метод возвращает b, то есть 12.",

            feedbackWrong =
                "Неверно. Условие a > b (5 > 12) ложно, поэтому выполняется второй return b, и метод возвращает 12."
        )
    )

    val lesson7Questions = listOf(

        QuizQuestion(
            id = 1,
            label = "Вопрос 1",
            text = "Как называется специальный метод, который вызывается при создании объекта?",

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "Деструктор"),
                QuizOption(id = "b", letter = "B", text = "Инициализатор"),
                QuizOption(id = "c", letter = "C", text = "Конструктор"),
                QuizOption(id = "d", letter = "D", text = "Метод Main")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Верно! Конструктор — это специальный метод класса, который автоматически вызывается при создании объекта с помощью new.",

            feedbackWrong =
                "Неверно. При создании объекта автоматически вызывается конструктор — метод с тем же именем, что и класс."
        ),

        QuizQuestion(
            id = 2,
            label = "Вопрос 2",
            text = "Что выведет следующий код?",

            codeSnippet = """
            class Dog
            {
                public string Name;
                public int Age;
            }
            
            Dog dog = new Dog();
            dog.Name = "Шарик";
            dog.Age = 3;
            Console.WriteLine(dog.Name);
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "Dog"),
                QuizOption(id = "b", letter = "B", text = "Ошибка"),
                QuizOption(id = "c", letter = "C", text = "3"),
                QuizOption(id = "d", letter = "D", text = "Шарик")
            ),

            correctOptionId = "d",

            feedbackCorrect =
                "Правильно! Создаётся объект типа Dog, его полю Name присваивается «Шарик», именно оно и выводится.",

            feedbackWrong =
                "Неверно. Поле Name объекта dog получает значение \"Шарик\", которое затем и выводится через Console.WriteLine."
        ),

        QuizQuestion(
            id = 3,
            label = "Вопрос 3",
            text = "Что выведет следующий код?",

            codeSnippet = """
            class Car
            {
                public string Model;
                
                public void ShowModel()
                {
                    Console.WriteLine("Модель: " + Model);
                }
            }
            
            Car car = new Car();
            car.Model = "Tesla";
            car.ShowModel();
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "Model"),
                QuizOption(id = "b", letter = "B", text = "Модель: Model"),
                QuizOption(id = "c", letter = "C", text = "Модель: Tesla"),
                QuizOption(id = "d", letter = "D", text = "Ошибка")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Верно! Метод ShowModel() обращается к полю Model объекта, которое равно \"Tesla\", и выводит «Модель: Tesla».",

            feedbackWrong =
                "Неверно. Метод ShowModel() читает поле Model текущего объекта. Так как car.Model = \"Tesla\", выводится «Модель: Tesla»."
        ),

        QuizQuestion(
            id = 4,
            label = "Вопрос 4",
            text = "Что выведет следующий код?",

            codeSnippet = """
            class Person
            {
                public string Name;
                
                public Person(string name)
                {
                    Name = name;
                }
            }
            
            Person p = new Person("Иван");
            Console.WriteLine(p.Name);
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "Person"),
                QuizOption(id = "b", letter = "B", text = "name"),
                QuizOption(id = "c", letter = "C", text = "Ошибка"),
                QuizOption(id = "d", letter = "D", text = "Иван")
            ),

            correctOptionId = "d",

            feedbackCorrect =
                "Правильно! При создании объекта конструктор получает \"Иван\" и присваивает это значение полю Name. Именно оно и выводится.",

            feedbackWrong =
                "Неверно. Конструктор принимает аргумент \"Иван\" и сохраняет его в поле Name. Поэтому p.Name возвращает «Иван»."
        ),

        QuizQuestion(
            id = 5,
            label = "Вопрос 5",
            text = "Что выведет следующий код?",

            codeSnippet = """
            class Counter
            {
                public int Count = 0;
                
                public void Increment()
                {
                    Count++;
                }
            }
            
            Counter c = new Counter();
            c.Increment();
            c.Increment();
            c.Increment();
            Console.WriteLine(c.Count);
            """.trimIndent().highlightSyntax(),

            options = listOf(
                QuizOption(id = "a", letter = "A", text = "0"),
                QuizOption(id = "b", letter = "B", text = "1"),
                QuizOption(id = "c", letter = "C", text = "3"),
                QuizOption(id = "d", letter = "D", text = "Ошибка")
            ),

            correctOptionId = "c",

            feedbackCorrect =
                "Верно! Метод Increment() увеличивает поле Count на 1 при каждом вызове. После трёх вызовов Count равен 3.",

            feedbackWrong =
                "Неверно. Каждый вызов Increment() увеличивает Count на 1. После трёх вызовов Count = 0 + 1 + 1 + 1 = 3."
        )
    )

    fun getQuizForLesson(lessonId: Int): List<QuizQuestion> {

        return when (lessonId) {

            1 -> lesson1Questions
            2 -> lesson2Questions
            3 -> lesson3Questions
            4 -> lesson4Questions
            5 -> lesson5Questions
            6 -> lesson6Questions
            7 -> lesson7Questions

            else -> emptyList()
        }
    }
}