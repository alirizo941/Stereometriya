package com.example.stereometriya1

data class Question(
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
) 