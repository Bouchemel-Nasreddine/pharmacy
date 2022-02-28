package com.exemple.exo_quatre.fragments

import android.content.Context
import android.content.SharedPreferences
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exemple.exo_quatre.data.Pharmacy
import com.exemple.exo_quatre.adapters.PharmacyAdapter
import com.exemple.exo_quatre.R
import com.exemple.exo_quatre.data.User

class MainFragment : Fragment() {

    val list = ArrayList<Pharmacy>()
    val description =
        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list.add(
            Pharmacy(
                R.drawable.pharmacy,
                "Zaki Pharmacy",
                "bouraoui amar, El harrach",
                "0550743933",
                "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                Pair(36.71414582806839, 3.152710001393291),
                "12:13",
                "12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy,
                "Zaki Pharmacy",
                "bouraoui amar, El harrach",
                "0550743933",
                "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                Pair(36.27214450981929, 6.700339455946398),
                "12:13",
                "12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy,
                "Zaki Pharmacy",
                "bouraoui amar, El harrach",
                "0550743933",
                "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                Pair(36.71414582806839, 3.152710001393291),
                "12:13",
                "12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy,
                "Zaki Pharmacy",
                "bouraoui amar, Rouiba",
                "0550743933",
                "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                Pair(36.71414582806839, 3.152710001393291),
                "12:13",
                "12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy,
                "Zaki Pharmacy",
                "bouraoui amar, Rouiba",
                "0550743933",
                "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                Pair(36.71414582806839, 3.152710001393291),
                "12:13",
                "12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy,
                "Zaki Pharmacy",
                "bouraoui amar, El harrach",
                "0550743933",
                "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                Pair(36.71414582806839, 3.152710001393291),
                "12:13",
                "12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy,
                "Zaki Pharmacy",
                "bouraoui amar, El harrach",
                "0550743933",
                "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                Pair(36.71414582806839, 3.152710001393291),
                "12:13",
                "12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy,
                "Zaki Pharmacy",
                "bouraoui amar, Rouiba",
                "0550743933",
                "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                Pair(36.71414582806839, 3.152710001393291),
                "12:13",
                "12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        list.add(
            Pharmacy(
                R.drawable.pharmacy,
                "Zaki Pharmacy",
                "bouraoui amar, El harrach",
                "0550743933",
                "https://www.google.fr/maps/place/pharmacie+de+garde+ben+amar/@36.713461,3.1502406,16.52z/data=!4m5!3m4!1s0x128e5243e3294abd:0x209125d411f6b358!8m2!3d36.7141079!4d3.1526814",
                Pair(36.71414582806839, 3.152710001393291),
                "12:13",
                "12:19",
                description,
                "https://www.facebook.com/nasreddine.bouchemel.1",
            )
        )

        val cities = resources.getStringArray(R.array.cities)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val pref = requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()

        val pharmacyRecyclerView = view.findViewById<RecyclerView>(R.id.pharmacy_list)
        val citiesSpinner = view.findViewById<Spinner>(R.id.city_spinner)

//        if (pref.getBoolean("connected", false)) {
//            val user = User(pref.getString("name", "")!!,
//                pref.getString("email", "")!!,
//                pref.getString("password", "")!!,
//            )
//            loginCard.visibility = View.INVISIBLE
//        }

        pharmacyRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayout.VERTICAL
            )
        )
        pharmacyRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = PharmacyAdapter(requireActivity(), view, list)
        pharmacyRecyclerView.adapter = adapter

        val spinnerAdapter = ArrayAdapter.createFromResource(
            this.requireContext(), R.array.cities,
            android.R.layout.simple_spinner_item
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        citiesSpinner.adapter = spinnerAdapter
        citiesSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                Log.d("city", "onItemSelected: " + cities[position])
                adapter.filter.filter(cities[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        return view
    }

//    private fun desconnect(view: View, editor: SharedPreferences.Editor) {
//        editor.putBoolean("connected", false)
//        editor.apply()
//        editor.commit()
//        view.findNavController().navigate(R.id.action_mainFragment_self)
//    }

}