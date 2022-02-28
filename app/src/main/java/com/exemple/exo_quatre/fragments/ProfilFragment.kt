package com.exemple.exo_quatre.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.exemple.exo_quatre.R
import com.exemple.exo_quatre.data.User


class ProfilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_profil, container, false)
        val loginBtn = view.findViewById<Button>(R.id.go_to_login_btn)

        loginBtn.setOnClickListener(
            View.OnClickListener {
                findNavController().navigate(R.id.action_profil_to_loginFragment)
            }
        )

        val pref = requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()

        if (pref.getBoolean("connected", false)) {
            val user = User(pref.getString("name", "")!!,
                pref.getString("email", "")!!,
                pref.getString("password", "")!!,
            )
            loginBtn.visibility = View.INVISIBLE
        }

        return view
    }

}