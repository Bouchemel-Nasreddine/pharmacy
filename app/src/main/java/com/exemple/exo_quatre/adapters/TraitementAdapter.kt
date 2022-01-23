package com.exemple.exo_quatre.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exemple.exo_quatre.R
import com.exemple.exo_quatre.data.Traitement

class TraitementAdapter(val context: Context, val view: View, val data: List<Traitement>)  :
    RecyclerView.Adapter<TraitementAdapter.TraitementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TraitementViewHolder {
        return TraitementViewHolder(
            LayoutInflater.from(context).inflate(R.layout.traitement_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TraitementViewHolder, position: Int) {
        holder.timeView.text = data[position].debut + " - " + data[position].dure
        holder.descriptionView.text = data[position].description
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class TraitementViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val timeView = view.findViewById<TextView>(R.id.traitemtn_time)
        val descriptionView = view.findViewById<TextView>(R.id.traitement_description)
    }
}