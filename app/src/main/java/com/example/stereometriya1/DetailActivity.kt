package com.example.stereometriya1

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultText: TextView
    private lateinit var shapeImage: ImageView
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        input3 = findViewById(R.id.input3)
        calculateButton = findViewById(R.id.calculateButton)
        resultText = findViewById(R.id.resultText)
        shapeImage = findViewById(R.id.shapeImage)
        backButton = findViewById(R.id.backButton)

        val formulaName = intent.getStringExtra("formula_name")
        setupUIForFormula(formulaName)

        backButton.setOnClickListener {
            finish()
        }

        calculateButton.setOnClickListener {
            calculateFormula(formulaName)
        }
    }

    private fun setupUIForFormula(name: String?) {
        input1.visibility = android.view.View.VISIBLE
        input2.visibility = android.view.View.VISIBLE
        input3.visibility = android.view.View.VISIBLE

        when (name) {
            "Kub" -> {
                input1.hint = "Tomon uzunligi (a)"
                input2.visibility = android.view.View.GONE
                input3.visibility = android.view.View.GONE
                shapeImage.setImageResource(R.drawable.kub)
            }

            "Silindr" -> {
                input1.hint = "Radius (r)"
                input2.hint = "Balandlik (h)"
                input2.visibility = android.view.View.VISIBLE
                input3.visibility = android.view.View.GONE
                shapeImage.setImageResource(R.drawable.slinder)
            }

            "Konus" -> {
                input1.hint = "Radius (r)"
                input2.hint = "Balandlik (h)"
                input2.visibility = android.view.View.VISIBLE
                input3.visibility = android.view.View.GONE
                shapeImage.setImageResource(R.drawable.konus)
            }

            "Shar" -> {
                input1.hint = "Radius (r)"
                input2.visibility = android.view.View.GONE
                input3.visibility = android.view.View.GONE
                shapeImage.setImageResource(R.drawable.shar)
            }

            "Parallelepiped" -> {
                input1.hint = "a ni kiriting"
                input2.hint = "b ni kiriting"
                input3.hint = "c ni kiriting"
                input2.visibility = android.view.View.VISIBLE
                input3.visibility = android.view.View.VISIBLE
                shapeImage.setImageResource(R.drawable.parallelepiped)
            }

            "Piramida" -> {
                input1.hint = "Asosning 1-tomoni (a)"
                input2.hint = "Asosning 2-tomoni (b)"
                input3.hint = "Balandlik (h)"

                input2.visibility = android.view.View.VISIBLE
                input3.visibility = android.view.View.VISIBLE

                shapeImage.setImageResource(R.drawable.piramida)
            }

            "Prizma" -> {
                input1.hint = "Asos yuzasi (a)"
                input2.hint = "Balandlik (h)"
                input2.visibility = android.view.View.VISIBLE
                input3.visibility = android.view.View.GONE
                shapeImage.setImageResource(R.drawable.prizma)
            }

            "Tetraedr" -> {
                input1.hint = "Tomon uzunligi (a)"
                input2.visibility = android.view.View.GONE
                input3.visibility = android.view.View.GONE
                shapeImage.setImageResource(R.drawable.tetraedr)
            }

            "Ellipsoid" -> {
                input1.hint = "a ni kiriting"
                input2.hint = "b ni kiriting"
                input3.hint = "c ni kiriting"
                input2.visibility = android.view.View.VISIBLE
                input3.visibility = android.view.View.VISIBLE
                shapeImage.setImageResource(R.drawable.ellipsoid)
            }

            "Kesilgan konus" -> {
                input1.hint = "Yuqori radius (r1)"
                input2.hint = "Pastki radius (r2)"
                input3.hint = "Balandlik (h)"
                input2.visibility = android.view.View.VISIBLE
                input3.visibility = android.view.View.VISIBLE
                shapeImage.setImageResource(R.drawable.truncatedkonus)
            }

            else -> {
                input1.hint = "Qiymat 1"
                input2.visibility = android.view.View.GONE
                input3.visibility = android.view.View.GONE
                shapeImage.setImageResource(R.drawable.ic_shape_placeholder)
            }
        }

        // Faqat raqamli klaviatura chiqishi uchun:
        input1.inputType = android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
        input2.inputType = android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
        input3.inputType = android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
    }


    private fun calculateFormula(name: String?) {
        try {
            val a = input1.text.toString().toDoubleOrNull()
            val b = input2.text.toString().toDoubleOrNull()
            val c = input3.text.toString().toDoubleOrNull()

            val result = when (name) {
                "Kub" -> {
                    if (a == null) return showError()
                    val S = 6 * a * a
                    val V = a * a * a
                    val d = a * Math.sqrt(3.0)
                    val formulaText = "S = 6a²\nS = 6 * ${a}² = ${"%.2f".format(S)}" +
                            "\nV = a³\nV = ${a}³ = ${"%.2f".format(V)}" +
                            "\nd = a√3\nd = ${a}√3 = ${"%.2f".format(d)}"
                    formulaText
                }

                "Silindr" -> {
                    if (a == null || b == null) return showError()
                    val S = 2 * Math.PI * a * (a + b)
                    val V = Math.PI * a * a * b
                    val formulaText = "S = 2πr(r + h)\nS = 2π * ${a} * (${a} + ${b}) = ${"%.2f".format(S)}" +
                            "\nV = πr²h\nV = π * ${a}² * ${b} = ${"%.2f".format(V)}"
                    formulaText
                }

                "Konus" -> {
                    if (a == null || b == null) return showError()
                    val l = Math.sqrt(a * a + b * b)
                    val S = Math.PI * a * (a + l)
                    val V = (1.0 / 3) * Math.PI * a * a * b
                    val formulaText = "l = √(r² + h²)\nl = √(${a}² + ${b}²) = ${"%.2f".format(l)}" +
                            "\nS = πr(r + l)\nS = π * ${a} * (${a} + ${"%.2f".format(l)}) = ${"%.2f".format(S)}" +
                            "\nV = (1/3)πr²h\nV = (1/3) * π * ${a}² * ${b} = ${"%.2f".format(V)}"
                    formulaText
                }

                "Shar" -> {
                    if (a == null) return showError()
                    val S = 4 * Math.PI * a * a
                    val V = (4.0 / 3) * Math.PI * a * a * a
                    val formulaText = "S = 4πr²\nS = 4π * ${a}² = ${"%.2f".format(S)}" +
                            "\nV = (4/3)πr³\nV = (4/3)π * ${a}³ = ${"%.2f".format(V)}"
                    formulaText
                }

                "Parallelepiped" -> {
                    if (a == null || b == null || c == null) return showError()
                    val S = 2 * (a * b + b * c + a * c)
                    val V = a * b * c
                    val d = Math.sqrt(a * a + b * b + c * c)
                    val formulaText = "S = 2(ab + bc + ac)\nS = 2(${a}*${b} + ${b}*${c} + ${a}*${c}) = ${"%.2f".format(S)}" +
                            "\nV = abc\nV = ${a}*${b}*${c} = ${"%.2f".format(V)}" +
                            "\nd = √(a² + b² + c²)\nd = √(${a}² + ${b}² + ${c}²) = ${"%.2f".format(d)}"
                    formulaText
                }

                "Tetraedr" -> {
                    if (a == null) return showError()
                    val S = Math.sqrt(3.0) * a * a
                    val V = (a * a * a) / (6 * Math.sqrt(2.0))
                    val h = (a * Math.sqrt(6.0)) / 3
                    val formulaText = "S = √3 · a²\nS = √3 * ${a}² = ${"%.2f".format(S)}" +
                            "\nV = a³ / (6√2)\nV = ${a}³ / (6√2) = ${"%.2f".format(V)}" +
                            "\nh = a√6 / 3\nh = ${a}√6 / 3 = ${"%.2f".format(h)}"
                    formulaText
                }

                "Ellipsoid" -> {
                    if (a == null || b == null || c == null) return showError()
                    val V = (4.0 / 3) * Math.PI * a * b * c
                    val formulaText = "V = (4/3)πabc\nV = (4/3)π * ${a} * ${b} * ${c} = ${"%.2f".format(V)}"
                    formulaText
                }

                "Kesilgan konus" -> {
                    if (a == null || b == null || c == null) return showError()
                    val r1 = a
                    val r2 = b
                    val h = c
                    val l = Math.sqrt((r1 - r2) * (r1 - r2) + h * h)
                    val S = Math.PI * (r1 * r1 + r2 * r2 + (r1 + r2) * l)
                    val V = (1.0 / 3) * Math.PI * h * (r1 * r1 + r1 * r2 + r2 * r2)
                    val formulaText = "l = √((r₁ - r₂)² + h²)\nl = √((${r1} - ${r2})² + ${h}²) = ${"%.2f".format(l)}" +
                            "\nS = π(r₁² + r₂² + (r₁ + r₂)l)\nS = π * (${r1}² + ${r2}² + (${r1} + ${r2}) * ${"%.2f".format(l)}) = ${"%.2f".format(S)}" +
                            "\nV = (1/3)πh(r₁² + r₁r₂ + r₂²)\nV = (1/3)π * ${h} * (${r1}² + ${r1}*${r2} + ${r2}²) = ${"%.2f".format(V)}"
                    formulaText
                }

                "Piramida" -> {
                    if (a == null || b == null || c == null) return showError()

                    val B = a * b
                    val V = (1.0 / 3.0) * B * c

                    val formulaText =
                        "Asos yuzasi B = a·b = ${a} * ${b} = ${"%.2f".format(B)}" +
                                "\n\nV = (1/3)·B·h\nV = (1/3) * ${"%.2f".format(B)} * ${c} = ${"%.2f".format(V)}"

                    formulaText
                }





                else -> "Shakl tanlanmagan yoki nomaʼlum"
            }

            resultText.text = result

        } catch (e: Exception) {
            showError()
        }
    }



    private fun showError() {
        resultText.text = "Iltimos, to‘g‘ri son kiriting!"
    }
}
