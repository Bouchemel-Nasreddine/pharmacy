package com.exemple.exo_quatre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment() {

    val list = ArrayList<Pharmacy>()

    val description = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list.add(
            Pharmacy(
                R.drawable.pharmacy, "Zaki Pharmacy",
                "bouraoui amar, el harrache", "0550743933", "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                "12:13","12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy, "Zaki Pharmacy",
                "bouraoui amar, el harrache", "0550743933", "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                "12:13","12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy, "Zaki Pharmacy",
                "bouraoui amar, el harrache", "0550743933", "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                "12:13","12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy, "Zaki Pharmacy",
                "bouraoui amar, el harrache", "0550743933", "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                "12:13","12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy, "Zaki Pharmacy",
                "bouraoui amar, el harrache", "0550743933", "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                "12:13","12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy, "Zaki Pharmacy",
                "bouraoui amar, el harrache", "0550743933", "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                "12:13","12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy, "Zaki Pharmacy",
                "bouraoui amar, el harrache", "0550743933", "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                "12:13","12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy, "Zaki Pharmacy",
                "bouraoui amar, el harrache", "0550743933", "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                "12:13","12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy, "Zaki Pharmacy",
                "bouraoui amar, el harrache", "0550743933", "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                "12:13","12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val pharmacyRecyclerView = view.findViewById<RecyclerView>(R.id.pharmacy_list)

        pharmacyRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayout.VERTICAL
            )
        )

        pharmacyRecyclerView.layoutManager = LinearLayoutManager(requireActivity())

        val adapter = PharmacyAdapter(requireActivity(), view, list)

        pharmacyRecyclerView.adapter = adapter

        return view
    }

}