package com.example.stereometriya1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.stereometriya1.R
import com.example.stereometriya1.FormulaAdapter
import com.example.stereometriya1.Formula

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FormulaAdapter
    private val formulaList = listOf(
        Formula("Kub", "Hajmi: V = a³\nYuzi: S = 6a²", R.drawable.kub),
        Formula("Tetraedr", "Hajmi: V = a³ / (6√2)\nYuzi: S = √3·a²\nBalandlik: h = a√6 / 3", R.drawable.tetraedr),
        Formula("Konus", "Hajmi: V = (1/3)πr²h\nYuzi: S = πr(r + l)", R.drawable.konus),
        Formula("Shar", "Hajmi: V = (4/3)πr³\nYuzi: S = 4πr²", R.drawable.shar),
        Formula("Piramida", "Hajmi: V = (1/3)B·h\nYuzi: S = B + (1/2)P·l", R.drawable.piramida),
        Formula("Kesilgan konus", "Hajmi: V = (1/3)πh(r₁² + r₁r₂ + r₂²)\nYuzi: S = π(r₁² + r₂² + (r₁ + r₂)l)", R.drawable.truncatedkonus),
        Formula("Ellipsoid", "Hajmi: V = (4/3)πabc", R.drawable.ellipsoid),
        Formula("Silindr", "Hajmi: V = πr²h\nYuzi: S = 2πr(h + r)", R.drawable.slinder)

    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            recyclerView = view.findViewById(R.id.formulaRecyclerView)
            adapter = FormulaAdapter(formulaList)
            recyclerView.adapter = adapter
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
