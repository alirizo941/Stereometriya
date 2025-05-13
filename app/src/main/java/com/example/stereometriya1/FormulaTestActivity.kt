package com.example.stereometriya1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.widget.TextView
import android.widget.ImageView

class FormulaTestActivity : AppCompatActivity() {
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
            "Kubning hajmi qanday formula bilan hisoblanadi?",
            listOf("V = a³", "V = a²", "V = 4πr³/3", "V = πr²h"),
            0
        ),
        Question(
            "Silindrning yon sirti maydoni qanday formula bilan hisoblanadi?",
            listOf("S = 2πrh", "S = πr²", "S = 4πr²", "S = πr²h"),
            0
        ),
        Question(
            "Konusning to'liq sirti maydoni qanday formula bilan hisoblanadi?",
            listOf("S = πr² + πrl", "S = πr²", "S = 4πr²", "S = 2πrh"),
            0
        ),
        Question(
            "Sharning hajmi qanday formula bilan hisoblanadi?",
            listOf("V = 4πr³/3", "V = πr²h", "V = a³", "V = πr²"),
            0
        ),
        Question(
            "Ellipsoidning hajmi qanday formula bilan hisoblanadi?",
            listOf("V = 4πabc/3", "V = πr²h", "V = a³", "V = πr²"),
            0
        ),
        Question(
            "Kesilgan konusning hajmi qanday formula bilan hisoblanadi?",
            listOf("V = πh(R² + Rr + r²)/3", "V = πr²h", "V = a³", "V = πr²"),
            0
        ),
        Question(
            "Tetraedrning hajmi qanday formula bilan hisoblanadi?",
            listOf("V = a³√2/12", "V = πr²h", "V = a³", "V = πr²"),
            0
        ),
        Question(
            "Piramidaning hajmi qanday formula bilan hisoblanadi?",
            listOf("V = Sh/3", "V = πr²h", "V = a³", "V = πr²"),
            0
        ),
        Question(
            "Kubning to'liq sirti maydoni qanday formula bilan hisoblanadi?",
            listOf("S = 6a²", "S = πr²", "S = 4πr²", "S = 2πrh"),
            0
        ),
        Question(
            "Silindrning to'liq sirti maydoni qanday formula bilan hisoblanadi?",
            listOf("S = 2πr² + 2πrh", "S = πr²", "S = 4πr²", "S = 2πrh"),
            0
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formula_test)

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