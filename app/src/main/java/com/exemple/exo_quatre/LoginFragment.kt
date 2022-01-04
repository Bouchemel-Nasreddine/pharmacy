package com.exemple.exo_quatre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val loginBtn = view.findViewById<MaterialButton>(R.id.sign_btn)
        val signUpBtn = view.findViewById<MaterialButton>(R.id.sign_up_button)
        val passwordEditText = view.findViewById<TextInputEditText>(R.id.password_edit_text)
        val emailEditText = view.findViewById<TextInputEditText>(R.id.email_edit_text)

        loginBtn.setOnClickListener(
            View.OnClickListener {
                view.findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }
        )

        signUpBtn.setOnClickListener(
            View.OnClickListener {
                view.findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
            }
        )

        return view
    }
}