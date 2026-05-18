package com.example.csharplearningapp.data

import androidx.compose.ui.text.AnnotatedString

sealed class TheoryStep {
    data class Text(val content: String) : TheoryStep()
    data class TextWithInlineCode(val code: String, val text: String) : TheoryStep()
    data class BulletList(val items: List<Pair<String, String>>) : TheoryStep()
    data class CodeSnippet(val lang: String, val code: AnnotatedString) : TheoryStep()
    data class SubHeader(val title: String) : TheoryStep()
}