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
import com.exemple.exo_quatre.adapters.TraitementAdapter
import com.exemple.exo_quatre.data.Traitement


class TraitementFragment : Fragment() {
    val list = ArrayList<Traitement>()
    val description =
        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        list.add(
            Traitement("10/04/2022", "3 mois", description)
        )
        list.add(
            Traitement("10/04/2022", "3 mois", description)
        )
        list.add(
            Traitement("10/04/2022", "3 mois", description)
        )
        list.add(
            Traitement("10/04/2022", "3 mois", description)
        )
        list.add(
            Traitement("10/04/2022", "3 mois", description)
        )
        list.add(
            Traitement("10/04/2022", "3 mois", description)
        )
        list.add(
            Traitement("10/04/2022", "3 mois", description)
        )

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_traitement, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.traitement_list)
        val loginView = view.findViewById<View>(R.id.go_to_login_from_traitement_view)


        val pref = requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)

        if (pref.getBoolean("connected", false)) {
            loginView.visibility = View.INVISIBLE
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = TraitementAdapter(requireContext(), view, list)
        recyclerView.adapter = adapter

        return view;
    }

}