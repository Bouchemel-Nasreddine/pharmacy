package com.exemple.exo_quatre.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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

        val user = arguments?.getSerializable("user") as User

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val pharmacyRecyclerView = view.findViewById<RecyclerView>(R.id.pharmacy_list)
        val citiesSpinner = view.findViewById<Spinner>(R.id.city_spinner)
        val mapsButton = view.findViewById<ImageButton>(R.id.map_button)
        val profileButton = view.findViewById<ImageButton>(R.id.profile_button)

        val dropDownMenu = PopupMenu(requireContext(), profileButton)
        val menu = dropDownMenu.menu

        dropDownMenu.menuInflater.inflate(R.menu.profile_menu, menu)

        dropDownMenu.setOnMenuItemClickListener (
            PopupMenu.OnMenuItemClickListener {
                    item ->
                when(item.itemId) {
                    R.id.traitement_item ->
                        view.findNavController().navigate(R.id.action_mainFragment_to_traitementFragment)
                    R.id.sign_out_item ->
                        desconnect(view)

                }
                true
            }
        )

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

        mapsButton.setOnClickListener(View.OnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_mapsFragment)
        })

        profileButton.setOnClickListener(
            View.OnClickListener {
                dropDownMenu.show()
            }
        )

        return view
    }

    private fun desconnect(view: View) {
        view.findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
    }

}