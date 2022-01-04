package com.exemple.exo_quatre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val signUpBtn = view.findViewById<MaterialButton>(R.id.sign_btn)

        signUpBtn.setOnClickListener(
            View.OnClickListener {
                view.findNavController().navigate(R.id.action_signUpFragment_to_mainFragment)
            }
        )

        return view
    }

}