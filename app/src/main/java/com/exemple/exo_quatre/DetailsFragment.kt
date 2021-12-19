package com.exemple.exo_quatre

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        val data = arguments?.getSerializable("data") as Pharmacy

        val image = view.findViewById(R.id.imageView) as ImageView
        val nom = view.findViewById(R.id.textView) as TextView
        val adresse = view.findViewById(R.id.textView2) as TextView
        val horaireOverture = view.findViewById(R.id.textView3) as TextView
        val horaireFermeture = view.findViewById(R.id.textView4) as TextView
        val TextDescriptif = view.findViewById(R.id.textView5) as TextView
        val UrlFacebook = view.findViewById(R.id.button) as Button
        val localisation = view.findViewById(R.id.button2) as Button

        nom.text = data.name
        adresse.text = data.adresse
        horaireFermeture.text = data.heureFerme
        horaireOverture.text = data.heureOuvert
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


        return view
    }

}