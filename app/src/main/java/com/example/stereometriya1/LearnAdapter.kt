package com.example.stereometriya1

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stereometriya1.R
import com.example.stereometriya1.ShapeInfo

class LearnAdapter(
    private val items: List<ShapeInfo>,
    private val onItemClick: (ShapeInfo) -> Unit
) : RecyclerView.Adapter<LearnAdapter.LearnViewHolder>() {
    private val TAG = "LearnAdapter"

    inner class LearnViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.shapeName)
        val image: ImageView = itemView.findViewById(R.id.shapeImage)
        val desc: TextView = itemView.findViewById(R.id.shapeDesc)

        init {
            itemView.setOnClickListener {
                try {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        onItemClick(items[position])
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Item click xatoligi: ${e.message}", e)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.learn_item, parent, false)
        return LearnViewHolder(view)
    }

    override fun onBindViewHolder(holder: LearnViewHolder, position: Int) {
        try {
            val item = items[position]
            holder.name.text = item.name
            holder.image.setImageResource(item.imageResId)
            holder.desc.text = item.description
        } catch (e: Exception) {
            Log.e(TAG, "Binding xatoligi: ${e.message}", e)
        }
    }

    override fun getItemCount(): Int = items.size
}



