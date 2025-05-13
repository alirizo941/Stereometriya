package com.example.stereometriya1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.widget.TextView
import android.widget.ImageView

class DefinitionTestActivity : AppCompatActivity() {
    private lateinit var questionText: TextView
    private lateinit var option1: CardView
    private lateinit var option2: CardView
    private lateinit var option3: CardView
    private lateinit var option4: CardView
    private lateinit var backButton: ImageView

    private var currentQuestionIndex = 0
    private var correctAnswers = 0
    private var wrongAnswers = 0

    private val questions = listOf(
        Question(
            "Kub qanday geometrik shakl?",
            listOf(
                "Barcha yoqlari kvadrat bo'lgan to'g'ri parallelepiped",
                "Barcha yoqlari to'g'ri to'rtburchak bo'lgan parallelepiped",
                "Barcha yoqlari romb bo'lgan parallelepiped",
                "Barcha yoqlari parallelogramm bo'lgan parallelepiped"
            ),
            0
        ),
        Question(
            "Silindr qanday geometrik shakl?",
            listOf(
                "Ikki parallel tekislik orasidagi sirt",
                "Bir nuqtadan chiqib, doira bo'ylab harakatlanuvchi to'g'ri chiziq",
                "Barcha yoqlari kvadrat bo'lgan to'g'ri parallelepiped",
                "Barcha yoqlari to'g'ri to'rtburchak bo'lgan parallelepiped"
            ),
            0
        ),
        Question(
            "Konus qanday geometrik shakl?",
            listOf(
                "Bir nuqtadan chiqib, doira bo'ylab harakatlanuvchi to'g'ri chiziq",
                "Ikki parallel tekislik orasidagi sirt",
                "Barcha yoqlari kvadrat bo'lgan to'g'ri parallelepiped",
                "Barcha yoqlari to'g'ri to'rtburchak bo'lgan parallelepiped"
            ),
            0
        ),
        Question(
            "Shar qanday geometrik shakl?",
            listOf(
                "Markazidan bir xil masofada joylashgan nuqtalar to'plami",
                "Ikki parallel tekislik orasidagi sirt",
                "Bir nuqtadan chiqib, doira bo'ylab harakatlanuvchi to'g'ri chiziq",
                "Barcha yoqlari kvadrat bo'lgan to'g'ri parallelepiped"
            ),
            0
        ),
        Question(
            "Ellipsoid qanday geometrik shakl?",
            listOf(
                "Uch o'qli ellips bo'ylab aylanishidan hosil bo'lgan sirt",
                "Markazidan bir xil masofada joylashgan nuqtalar to'plami",
                "Ikki parallel tekislik orasidagi sirt",
                "Bir nuqtadan chiqib, doira bo'ylab harakatlanuvchi to'g'ri chiziq"
            ),
            0
        ),
        Question(
            "Kesilgan konus qanday geometrik shakl?",
            listOf(
                "Konusning parallel tekislik bilan kesilgan qismi",
                "Uch o'qli ellips bo'ylab aylanishidan hosil bo'lgan sirt",
                "Markazidan bir xil masofada joylashgan nuqtalar to'plami",
                "Ikki parallel tekislik orasidagi sirt"
            ),
            0
        ),
        Question(
            "Tetraedr qanday geometrik shakl?",
            listOf(
                "To'rt uchli ko'pyoqlik",
                "Konusning parallel tekislik bilan kesilgan qismi",
                "Uch o'qli ellips bo'ylab aylanishidan hosil bo'lgan sirt",
                "Markazidan bir xil masofada joylashgan nuqtalar to'plami"
            ),
            0
        ),
        Question(
            "Piramida qanday geometrik shakl?",
            listOf(
                "Asos va uchlaridan biri asos tekisligida bo'lmagan ko'pyoqlik",
                "To'rt uchli ko'pyoqlik",
                "Konusning parallel tekislik bilan kesilgan qismi",
                "Uch o'qli ellips bo'ylab aylanishidan hosil bo'lgan sirt"
            ),
            0
        ),
        Question(
            "To'g'ri parallelepiped qanday geometrik shakl?",
            listOf(
                "Barcha yoqlari to'g'ri to'rtburchak bo'lgan parallelepiped",
                "Asos va uchlaridan biri asos tekisligida bo'lmagan ko'pyoqlik",
                "To'rt uchli ko'pyoqlik",
                "Konusning parallel tekislik bilan kesilgan qismi"
            ),
            0
        ),
        Question(
            "To'g'ri prizma qanday geometrik shakl?",
            listOf(
                "Yon qirralari asosga perpendikulyar bo'lgan prizma",
                "Barcha yoqlari to'g'ri to'rtburchak bo'lgan parallelepiped",
                "Asos va uchlaridan biri asos tekisligida bo'lmagan ko'pyoqlik",
                "To'rt uchli ko'pyoqlik"
            ),
            0
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_definition_test)

        initializeViews()
        setupClickListeners()
        showQuestion()
    }

    private fun initializeViews() {
        questionText = findViewById(R.id.questionText)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)
        backButton = findViewById(R.id.backButton)
    }

    private fun setupClickListeners() {
        option1.setOnClickListener { checkAnswer(0) }
        option2.setOnClickListener { checkAnswer(1) }
        option3.setOnClickListener { checkAnswer(2) }
        option4.setOnClickListener { checkAnswer(3) }
        backButton.setOnClickListener { finish() }
    }

    private fun showQuestion() {
        if (currentQuestionIndex < questions.size) {
            val question = questions[currentQuestionIndex]
            questionText.text = question.questionText
            
            val options = listOf(option1, option2, option3, option4)
            question.options.forEachIndexed { index, option ->
                (options[index].getChildAt(0) as TextView).text = option
            }
        } else {
            showResults()
        }
    }

    private fun checkAnswer(selectedOption: Int) {
        val question = questions[currentQuestionIndex]
        if (selectedOption == question.correctAnswerIndex) {
            correctAnswers++
            Toast.makeText(this, "To'g'ri!", Toast.LENGTH_SHORT).show()
        } else {
            wrongAnswers++
            Toast.makeText(this, "Noto'g'ri!", Toast.LENGTH_SHORT).show()
        }
        
        currentQuestionIndex++
        showQuestion()
    }

    private fun showResults() {
        val intent = Intent(this, TestResultActivity::class.java).apply {
            putExtra("correct_answers", correctAnswers)
            putExtra("wrong_answers", wrongAnswers)
        }
        startActivity(intent)
        finish()
    }
} 