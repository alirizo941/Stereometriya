package com.example.stereometriya1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stereometriya1.R
import com.example.stereometriya1.LearnAdapter
import com.example.stereometriya1.ShapeInfo
import com.example.stereometriya1.LearnDetailActivity

class LearnFragment : Fragment(R.layout.fragment_learn) {
    private val TAG = "LearnFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            val list = listOf(
                ShapeInfo(
                    "Kub",
                    "Kub - barcha tomonlari teng bo'lgan to'rtburchaklar parallelepiped.\n\n" +
                    "Xususiyatlari:\n" +
                    "• Barcha tomonlari teng kvadratlar\n" +
                    "• Barcha burchaklari 90°\n" +
                    "• 12 qirrasi, 8 uchi bor\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = a³\n" +
                    "• Yuzi: S = 6a²\n" +
                    "• Diagonal: d = a√3",
                    R.drawable.kub
                ),
                ShapeInfo(
                    "Silindr",
                    "Silindr - parallel ko'chirilgan doira orqali hosil qilingan geometrik jism.\n\n" +
                    "Xususiyatlari:\n" +
                    "• Ikkita teng parallel doira asos\n" +
                    "• Yon tomoni to'g'ri to'rtburchak\n" +
                    "• O'qi asoslarga perpendikulyar\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = πr²h\n" +
                    "• Yon yuzi: S = 2πrh\n" +
                    "• To'liq yuzi: S = 2πr(h + r)",
                    R.drawable.slinder
                ),
                ShapeInfo(
                    "Konus",
                    "Konus - asosiy doira va uning markazidan o'tuvchi to'g'ri chiziq orqali hosil qilingan geometrik jism.\n\n" +
                    "Xususiyatlari:\n" +
                    "• Doira asos\n" +
                    "• Cho'qqi nuqtasi\n" +
                    "• Yon tomoni konus yuzasi\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = (1/3)πr²h\n" +
                    "• Yon yuzi: S = πrl\n" +
                    "• To'liq yuzi: S = πr(r + l)",
                    R.drawable.konus
                ),
                ShapeInfo(
                    "Shar",
                    "Shar - markazidan teng masofada joylashgan nuqtalar to'plami.\n\n" +
                    "Xususiyatlari:\n" +
                    "• Barcha nuqtalari markazdan teng masofada\n" +
                    "• Har qanday kesim doira\n" +
                    "• Eng katta doira - katta doira\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = (4/3)πr³\n" +
                    "• Yuzi: S = 4πr²",
                    R.drawable.shar
                ),
                ShapeInfo(
                    "Ellipsoid",
                    "Ellipsoid - uch o'qli ellips aylanishi natijasida hosil bo'lgan geometrik jism.\n\n" +
                    "Xususiyatlari:\n" +
                    "• Uch o'qli ellips\n" +
                    "• Simmetrik shakl\n" +
                    "• Har qanday kesim ellips\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = (4/3)πabc\n" +
                    "• Yuzi: S = 2π(c² + (bc²/√(a²-c²))·F(θ,m))",
                    R.drawable.ellipsoid
                ),
                ShapeInfo(
                    "Kesilgan konus",
                    "Kesilgan konus - parallel tekislik bilan kesilgan konus.\n\n" +
                    "Xususiyatlari:\n" +
                    "• Ikkita turli radiusli doira asos\n" +
                    "• Yon tomoni kesilgan konus yuzasi\n" +
                    "• O'qi asoslarga perpendikulyar\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = (1/3)πh(r₁² + r₁r₂ + r₂²)\n" +
                    "• Yon yuzi: S = π(r₁ + r₂)l\n" +
                    "• To'liq yuzi: S = π(r₁² + r₂² + (r₁ + r₂)l)",
                    R.drawable.truncatedkonus
                ),
                ShapeInfo(
                    "Tetraedr",
                    "Tetraedr - to'rt teng tengburchakli yuzalardan tashkil topgan ko'pyoqlik.\n\n" +
                    "Xususiyatlari:\n" +
                    "• To'rt teng tengburchakli yuz\n" +
                    "• 6 qirrasi, 4 uchi bor\n" +
                    "• Har bir uchi uchta yuzaga tegishli\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = a³ / (6√2)\n" +
                    "• Yuzi: S = √3·a²\n" +
                    "• Balandlik: h = a√6 / 3",
                    R.drawable.tetraedr
                ),
                ShapeInfo(
                    "Piramida",
                    "Piramida - ko'pburchak asos va uning markazidan o'tuvchi to'g'ri chiziq orqali hosil qilingan geometrik jism.\n\n" +
                    "Xususiyatlari:\n" +
                    "• Ko'pburchak asos\n" +
                    "• Cho'qqi nuqtasi\n" +
                    "• Yon tomoni uchburchaklar\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = (1/3)B·h\n" +
                    "• Yon yuzi: S = (1/2)P·l\n" +
                    "• To'liq yuzi: S = B + (1/2)P·l",
                    R.drawable.piramida
                )
            )

            val rv = view.findViewById<RecyclerView>(R.id.learnRecyclerView)
            if (rv != null) {
                rv.layoutManager = LinearLayoutManager(context)
                
                rv.adapter = LearnAdapter(list) { shape ->
                    try {
                        val intent = Intent(context, LearnDetailActivity::class.java).apply {
                            putExtra("shape_name", shape.name)
                            putExtra("shape_image", shape.imageResId)
                            putExtra("shape_description", shape.description)
                        }
                        startActivity(intent)
                    } catch (e: Exception) {
                        Log.e(TAG, "Activity ochishda xatolik: ${e.message}", e)
                    }
                }
            } else {
                Log.e(TAG, "RecyclerView topilmadi!")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Fragment yaratishda xatolik: ${e.message}", e)
        }
    }
}
