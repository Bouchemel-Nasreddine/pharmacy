package com.exemple.exo_quatre.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.exemple.exo_quatre.R
import com.exemple.exo_quatre.data.Commande

class CommandeAdapter(val context: Context, val view: View, val data: List<Commande>) :
    RecyclerView.Adapter<CommandeAdapter.CommandeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommandeViewHolder {
        return CommandeViewHolder(
            LayoutInflater.from(context).inflate(R.layout.commande_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommandeViewHolder, position: Int) {
        holder.etatView.text = data[position].etat
        holder.imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.pharmacy))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CommandeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<ImageView>(R.id.commande_image)
        val etatView = view.findViewById<TextView>(R.id.commande_etat)
    }

}