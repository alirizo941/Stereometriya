package com.example.stereometriya1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class   TestFragment : Fragment() {
    private val TAG = "TestFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<CardView>(R.id.definitionTestCard).setOnClickListener {
            try {
                context?.let { ctx ->
                    startActivity(Intent(ctx, DefinitionTestActivity::class.java))
                } ?: run {
                    Log.e(TAG, "Context is null")
                    Toast.makeText(activity, "Xatolik yuz berdi", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e(TAG, "Activity ochishda xatolik: ${e.message}", e)
                Toast.makeText(activity, "Xatolik yuz berdi", Toast.LENGTH_SHORT).show()
            }
        }

        view.findViewById<CardView>(R.id.formulaTestCard).setOnClickListener {
            try {
                context?.let { ctx ->
                    startActivity(Intent(ctx, FormulaTestActivity::class.java))
                } ?: run {
                    Log.e(TAG, "Context is null")
                    Toast.makeText(activity, "Xatolik yuz berdi", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Log.e(TAG, "Activity ochishda xatolik: ${e.message}", e)
                Toast.makeText(activity, "Xatolik yuz berdi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
