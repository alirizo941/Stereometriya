package com.example.stereometriya1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class LearnDetailActivity : AppCompatActivity() {
    private val TAG = "LearnDetailActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_learn_detail)

            // UI elementlarni topish
            val shapeName = findViewById<TextView>(R.id.shapeName)
            val shapeImage = findViewById<ImageView>(R.id.shapeImage)
            val shapeDescription = findViewById<TextView>(R.id.shapeDescription)
            val backButton = findViewById<ImageView>(R.id.backButton)

            // Ma'lumotlarni olish
            val name = intent.getStringExtra("shape_name") ?: ""
            val imageResId = intent.getIntExtra("shape_image", 0)
            val description = intent.getStringExtra("shape_description") ?: ""

            // UI elementlarga o'rnatish
            shapeName.text = name
            try {
                if (imageResId != 0) {
                    shapeImage.setImageResource(imageResId)
                } else {
                    shapeImage.setImageResource(R.drawable.ic_shape_placeholder)
                }
            } catch (e: Exception) {
                Log.e(TAG, "Rasm yuklashda xatolik: ${e.message}", e)
                shapeImage.setImageResource(R.drawable.ic_shape_placeholder)
            }
            shapeDescription.text = description

            // Orqaga tugma
            backButton.setOnClickListener {
                finish()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Activity yaratishda xatolik: ${e.message}", e)
            Toast.makeText(this, "Xatolik yuz berdi", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
