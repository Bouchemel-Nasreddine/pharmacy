package com.exemple.exo_quatre.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.exemple.exo_quatre.data.Pharmacy
import com.exemple.exo_quatre.R

class PharmacyAdapter(val context: Context, val view: View, val data: List<Pharmacy>) :
    RecyclerView.Adapter<PharmacyAdapter.PharmacyViewHolder>(), Filterable {

    var filteredData: List<Pharmacy> = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.pharmacy_item_layout, parent, false)

        return PharmacyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PharmacyViewHolder, position: Int) {
        holder.photoView.setImageDrawable(ContextCompat.getDrawable(context, data[position].img))
        holder.element.setOnClickListener(
            View.OnClickListener {
                val bundle = bundleOf("data" to data[position])
                view.findNavController()
                    .navigate(R.id.action_mainFragment_to_detailsFragment, bundle)

            }
        )
        holder.nameView.text = filteredData[position].name
        holder.phoneView.text = filteredData[position].phone.toString()
        holder.adresseView.text = filteredData[position].adresse
        holder.localisationView.setOnClickListener(View.OnClickListener {

            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(data[position].localisation)
            )
            context.startActivity(intent)

        })


    }

    override fun getItemCount(): Int {
        return filteredData.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val city = constraint?.toString() ?: ""

                val filteredList = ArrayList<Pharmacy>()
                data.filter {
                    (it.adresse.contains(city))
                }.forEach {
                    filteredList.add(it)
                }
                filteredData = filteredList


                return FilterResults().apply { values = filteredList }

            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                filteredData = if (results?.values == null)
                    ArrayList()
                else
                    results.values as ArrayList<Pharmacy>
                notifyDataSetChanged()
            }
        }
    }


    class PharmacyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photoView = view.findViewById<ImageView>(R.id.pharmacy_photo)
        val nameView = view.findViewById<TextView>(R.id.pharmacy_name)
        val phoneView = view.findViewById<TextView>(R.id.pharmacy_phone)
        val adresseView = view.findViewById<TextView>(R.id.pharmacy_adresse)
        val localisationView = view.findViewById<ImageButton>(R.id.pharmacy_localisation)
        val element = view.findViewById<ConstraintLayout>(R.id.item)

    }

}