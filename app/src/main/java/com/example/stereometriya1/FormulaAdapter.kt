package com.example.stereometriya1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stereometriya1.DetailActivity
import com.example.stereometriya1.R
import com.example.stereometriya1.Formula

class FormulaAdapter(private val formulaList: List<Formula>) :
    RecyclerView.Adapter<FormulaAdapter.FormulaViewHolder>() {

    class FormulaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val formulaName: TextView = itemView.findViewById(R.id.formulaNameText)
        val formulaDesc: TextView = itemView.findViewById(R.id.formulaDescText)
        val formulaImage: ImageView = itemView.findViewById(R.id.formulaImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormulaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.formula_item, parent, false)
        return FormulaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FormulaViewHolder, position: Int) {
        val formula = formulaList[position]
        holder.formulaName.text = formula.name
        holder.formulaDesc.text = formula.description
        holder.formulaImage.setImageResource(formula.imageResId)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("formula_name", formula.name)
            intent.putExtra("formula_desc", formula.description)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = formulaList.size
}
