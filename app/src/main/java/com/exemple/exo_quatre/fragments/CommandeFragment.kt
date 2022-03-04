package com.exemple.exo_quatre.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exemple.exo_quatre.R
import com.exemple.exo_quatre.adapters.CommandeAdapter
import com.exemple.exo_quatre.adapters.TraitementAdapter
import com.exemple.exo_quatre.data.Commande
import com.exemple.exo_quatre.data.User
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CommandeFragment : Fragment() {
    val list = ArrayList<Commande>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list.add(Commande(123456789, null, "lancée"))
        list.add(Commande(123456789, null, "en cours de traitement,"))
        list.add(Commande(123456789, null, "rejetée"))
        list.add(Commande(123456789, null, "lancée"))
        list.add(Commande(123456789, null, "en cours de traitement,"))
        list.add(Commande(123456789, null, "rejetée"))
        list.add(Commande(123456789, null, "en cours de traitement,"))
        list.add(Commande(123456789, null, "rejetée"))
        list.add(Commande(123456789, null, "lancée"))
        list.add(Commande(123456789, null, "en cours de traitement,"))
        list.add(Commande(123456789, null, "rejetée"))
        list.add(Commande(123456789, null, "lancée"))
        list.add(Commande(123456789, null, "lancée"))
        list.add(Commande(123456789, null, "traitée"))

        val view = inflater.inflate(R.layout.fragment_commande, container, false)

        val loginView = view.findViewById<View>(R.id.go_to_login_from_commande_view)
        val recyclerView = view.findViewById<RecyclerView>(R.id.commande_list)
        val addBtn = view.findViewById<ExtendedFloatingActionButton>(R.id.add_commande_btn)

        val pref = requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)

        if (pref.getBoolean("connected", false)) {
            loginView.visibility = View.INVISIBLE
        } else {
            addBtn.visibility = View.INVISIBLE
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CommandeAdapter(requireContext(), view, list)
        recyclerView.adapter = adapter

        addBtn.setOnClickListener(
            View.OnClickListener {
                list.add(Commande(123456789, null, "en cours de traitement,"))
                adapter.notifyItemInserted(list.size-1)
            }
        )

        return view
    }

}