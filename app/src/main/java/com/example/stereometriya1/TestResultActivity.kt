package com.example.stereometriya1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TestResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_result)

        val correctAnswers = intent.getIntExtra("correct_answers", 0)
        val wrongAnswers = intent.getIntExtra("wrong_answers", 0)
        val totalQuestions = correctAnswers + wrongAnswers
        val percentage = if (totalQuestions > 0) {
            (correctAnswers * 100) / totalQuestions
        } else 0

        findViewById<TextView>(R.id.correctAnswersText).text = "To'g'ri javoblar: $correctAnswers"
        findViewById<TextView>(R.id.wrongAnswersText).text = "Noto'g'ri javoblar: $wrongAnswers"
        findViewById<TextView>(R.id.percentageText).text = "Foiz: $percentage%"

        findViewById<Button>(R.id.finishButton).setOnClickListener {
            finish()
        }
    }
} 