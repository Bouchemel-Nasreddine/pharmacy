package com.exemple.exo_quatre.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.exemple.exo_quatre.ApiInterface
import com.exemple.exo_quatre.R
import com.exemple.exo_quatre.RetrofitInstance
import com.exemple.exo_quatre.data.SignInData
import com.exemple.exo_quatre.data.User
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val pref = requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()

        val loginBtn = view.findViewById<MaterialButton>(R.id.sign_btn)
        val signUpBtn = view.findViewById<MaterialButton>(R.id.sign_up_button)
        val passwordEditText = view.findViewById<TextInputEditText>(R.id.password_edit_text)
        val emailEditText = view.findViewById<TextInputEditText>(R.id.email_edit_text)
        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.nav_bar)

        loginBtn.setOnClickListener(
            View.OnClickListener {
                signin(
                    requireContext(),
                    view.findNavController(),
                    editor,
                    emailEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
        )

        signUpBtn.setOnClickListener(
            View.OnClickListener {
                view.findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
            }
        )

        return view
    }

    private fun signin(context: Context, nav: NavController, editor: SharedPreferences.Editor, email: String, password: String) {
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val signInInfo = SignInData(email, password)
        retIn.signin(signInInfo).enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    context,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val res = response.body()?.string()
                val user = User("", "", "", "")
                if (extractUserFromResponse(res, user)) {
                    editor.putBoolean("connected", true)
                    editor.putString("id", user.id)
                    editor.putString("name", user.name)
                    editor.putString("email", user.email)
                    editor.putString("password", user.password)
                    editor.apply()
                    editor.commit()
                    nav.navigate(R.id.action_loginFragment_to_mainFragment)
                } else {
                    Toast.makeText(context, "Login failed!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun extractUserFromResponse(response: String?, user: User): Boolean {
        try {
            val jsonRes = JSONObject(response)
            user.name = jsonRes.getString("name")
            user.email = jsonRes.getString("email")
            user.password = jsonRes.getString("password")
            return true
        } catch (e: JSONException) {
            e.printStackTrace()
            return false
        }
    }
}