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
                    "Kub — barcha qirralari teng bo‘lgan, olti yuzasi ham kvadrat shaklga ega bo‘lgan uch o‘lchamli geometrik jism.\n\n" +
                    "Xususiyatlari:\n" +
                    "• 6 ta teng kvadrat yuz, 12 ta teng qirra, 8 ta uchi bor.\n" +
                    "• Har bir uchda 3 ta qirra kesishadi va har bir burchak 90°.\n" +
                    "• Kub — to‘g‘ri parallelepipedning maxsus ko‘rinishi.\n" +
                    "• Kubning barcha diagonallari teng va uzunligi d = a√3.\n\n" +
                    "Qo‘llanilishi va ahamiyati:\n" +
                    "• Kub shakli arxitektura, qadoqlash, qurilish, matematika va san'atda keng qo‘llaniladi.\n" +
                    "• Rubik kubigi, quti, blok, lego va boshqalar kub shaklida bo‘ladi.\n" +
                    "• Kub kristall tuzilmalari ko‘plab minerallarda uchraydi (masalan, tuz kristali).\n\n" +
                    "Tarixiy ma'lumot:\n" +
                    "• Kub qadimda \"Platon jismlari\"dan biri sifatida qadrlangan va falsafiy ahamiyatga ega bo'lgan.\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = a³\n" +
                    "• To'liq yuza: S = 6a²\n" +
                    "• Diagonal: d = a√3\n" +
                    "• Yuz diagonali: d₁ = a√2",
                    R.drawable.kub
                ),
                ShapeInfo(
                    "Silindr",
                    "Silindr — ikki asos doirasi va ularni birlashtiruvchi egri sirtga ega bo'lgan jism.\n\n" +
                    "Xususiyatlari:\n" +
                    "• 2 ta teng doira asos, 1 ta egri yon sirt.\n" +
                    "• O'qi asoslarga perpendikulyar bo'lsa, to'g'ri silindr deyiladi.\n" +
                    "• Yon sirtini to'g'ri to'rtburchak tashkil qiladi.\n\n" +
                    "Qo'llanilishi:\n" +
                    "• Quvurlar, idishlar, dvigatel porshenlari, batareyalar, qog'oz rulonlari va boshqalar.\n" +
                    "• Arxitektura va texnikada ko'p uchraydi.\n\n" +
                    "Qiziqarli fakt:\n" +
                    "• Silindrning yon sirtini ochsangiz, to'g'ri to'rtburchak hosil bo'ladi.\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = πr²h\n" +
                    "• Yon yuza: S_yon = 2πrh\n" +
                    "• To'liq yuza: S = 2πr(h + r)",
                    R.drawable.slinder
                ),
                ShapeInfo(
                    "Konus",
                    "Konus — asosida doira va cho'qqisidan asos tekisligigacha perpendikulyar o'q o'tgan jism.\n\n" +
                    "Xususiyatlari:\n" +
                    "• 1 ta doira asos, 1 ta cho'qqi, 1 ta egri yon sirt.\n" +
                    "• Yon sirtini aylana yoy tashkil qiladi.\n\n" +
                    "Qo'llanilishi:\n" +
                    "• Vafli konus, muzqaymoq idishlari, texnikada, arxitektura va dizaynda.\n" +
                    "• Yorug'lik proyeksiyasi, optikada linza shakli sifatida.\n\n" +
                    "Tarixiy ma'lumot:\n" +
                    "• Konus qadimdan geometriyada o'rganilgan va Arximed asarlarida uchraydi.\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = (1/3)πr²h\n" +
                    "• Yon yuza: S_yon = πrl\n" +
                    "• To'liq yuza: S = πr(r + l)\n" +
                    "• Yon qirra: l = √(r² + h²)",
                    R.drawable.konus
                ),
                ShapeInfo(
                    "Shar",
                    "Shar — markazidan bir xil masofada joylashgan nuqtalar to'plami.\n\n" +
                    "Xususiyatlari:\n" +
                    "• 1 ta markaz, barcha nuqtalari markazdan r masofada.\n" +
                    "• Har qanday kesimi doira.\n\n" +
                    "Qo'llanilishi:\n" +
                    "• Sport to'plari, sayyoralar, tomchilar, biologik hujayralar va boshqalar.\n" +
                    "• Optikada linza va oynalar shakli sifatida.\n\n" +
                    "Qiziqarli fakt:\n" +
                    "• Yer va boshqa sayyoralar shakli taxminan shar (ellipsoid) ko'rinishida.\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = (4/3)πr³\n" +
                    "• Yuza: S = 4πr²",
                    R.drawable.shar
                ),
                ShapeInfo(
                    "Piramida",
                    "Piramida — asosida ko'pburchak va cho'qqisidan asos tekisligigacha perpendikulyar o'q o'tgan ko'pyoqlik.\n\n" +
                    "Xususiyatlari:\n" +
                    "• Asos — har qanday ko'pburchak.\n" +
                    "• Yon yuzalar — uchburchaklar.\n" +
                    "• Har bir asos tomoni bilan cho'qqi orasida yon qirra bor.\n\n" +
                    "Qo'llanilishi:\n" +
                    "• Misr piramidalari, zamonaviy arxitektura, matematika va san'atda.\n" +
                    "• Kimyoviy molekulalar shakli sifatida.\n\n" +
                    "Tarixiy ma'lumot:\n" +
                    "• Eng mashhur piramidalar — Giza piramidalari (Qadimgi Misr).\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = (1/3)B h (B — asos yuzasi, h — balandlik)\n" +
                    "• To'liq yuza: S = B + (1/2)P l (P — asos perimetri, l — yon qirra)",
                    R.drawable.piramida
                ),
                ShapeInfo(
                    "Kesilgan konus",
                    "Kesilgan konus — konusning yuqori qismi parallel tekislik bilan kesilganda hosil bo'ladi.\n\n" +
                    "Xususiyatlari:\n" +
                    "• 2 ta doira asos (turli radiusli), 1 ta egri yon sirt.\n" +
                    "• Yon sirtini aylana yoy tashkil qiladi.\n\n" +
                    "Qo'llanilishi:\n" +
                    "• Idishlar, texnika detallarida, arxitektura, lampalar, vaza va boshqalar.\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = (1/3)πh(r₁² + r₁r₂ + r₂²)\n" +
                    "• To'liq yuza: S = π(r₁² + r₂² + (r₁ + r₂)l)\n" +
                    "• Yon qirra: l = √((r₁ - r₂)² + h²)",
                    R.drawable.truncatedkonus
                ),
                ShapeInfo(
                    "Ellipsoid",
                    "Ellipsoid — uchta o'q bo'ylab cho'zilgan va aylanish natijasida hosil bo'lgan silliq yopiq sirt.\n\n" +
                    "Xususiyatlari:\n" +
                    "• Uchta asosiy o'q: a, b, c.\n" +
                    "• Har qanday kesimi ellips.\n" +
                    "• Simmetrik shakl.\n\n" +
                    "Qo'llanilishi:\n" +
                    "• Geodeziya, astronomiya (Yer shakli), biologiya (tuxum shakli), tibbiyotda (ko'z, yurak shakli).\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = (4/3)πabc",
                    R.drawable.ellipsoid
                ),
                ShapeInfo(
                    "Tetraedr",
                    "Tetraedr — to'rt teng uchburchakli yuzdan iborat eng oddiy ko'pyoqlik.\n\n" +
                    "Xususiyatlari:\n" +
                    "• 4 ta uchburchak yuz, 6 ta qirra, 4 ta uchi bor.\n" +
                    "• Har bir uchi 3 ta yuzaga tegishli.\n" +
                    "• Tetraedr — Platon jismlaridan biri.\n\n" +
                    "Qo'llanilishi:\n" +
                    "• Kimyo (molekulalar shakli), geometriya, dizayn, kristall tuzilmalarda.\n\n" +
                    "Qiziqarli fakt:\n" +
                    "• Tetraedr — eng barqaror ko'pyoqliklardan biri.\n\n" +
                    "Formulalar:\n" +
                    "• Hajmi: V = a³ / (6√2)\n" +
                    "• Yuza: S = √3a²\n" +
                    "• Balandlik: h = a√6 / 3",
                    R.drawable.tetraedr
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
