package com.exemple.exo_quatre.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.exemple.exo_quatre.data.Pharmacy
import com.exemple.exo_quatre.R

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        val data = arguments?.getSerializable("data") as Pharmacy

        val image = view.findViewById(R.id.details_photo) as ImageView
        val nom = view.findViewById(R.id.details_name) as TextView
        val adresse = view.findViewById(R.id.details_adresse) as TextView
        val horaireOverture = view.findViewById(R.id.details_open_time) as TextView
        val horaireFermeture = view.findViewById(R.id.details_close_time) as TextView
        val TextDescriptif = view.findViewById(R.id.details_description) as TextView
        val UrlFacebook = view.findViewById(R.id.details_facebook_button) as ImageButton
        val localisation = view.findViewById(R.id.details_location_button) as ImageButton
        val back = view.findViewById<ImageButton>(R.id.details_back_button)

        nom.text = data.name
        adresse.text = data.adresse
        horaireFermeture.text = "fermeture: " + data.heureFerme
        horaireOverture.text = "ouverture: " + data.heureOuvert
        TextDescriptif.text = data.textDescr
        image.setImageDrawable(ContextCompat.getDrawable(requireActivity(), data.img))
        localisation.setOnClickListener(
            View.OnClickListener {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(data.localisation)
                )
                startActivity(intent)
            }
        )

        UrlFacebook.setOnClickListener(
            View.OnClickListener {
                try {
                    requireActivity().getPackageManager().getPackageInfo("com.facebook.katana", 0)
                    val intent= Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/nasreddine.bouchemel.1"))
                    startActivity(intent)
                } catch (e: Exception) {
                    val intent= Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(data.UrlFace)

                    )
                    startActivity(intent)
                }

            }
        )

        back.setOnClickListener(View.OnClickListener {
            view.findNavController().navigate(R.id.action_detailsFragment_to_mainFragment)
        })

        return view
    }

}