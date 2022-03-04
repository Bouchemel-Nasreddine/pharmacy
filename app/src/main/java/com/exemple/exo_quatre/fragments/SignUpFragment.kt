package com.exemple.exo_quatre.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.exemple.exo_quatre.ApiInterface
import com.exemple.exo_quatre.R
import com.exemple.exo_quatre.RetrofitInstance
import com.exemple.exo_quatre.data.SignInData
import com.exemple.exo_quatre.data.User
import com.google.android.material.button.MaterialButton
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val signUpBtn = view.findViewById<MaterialButton>(R.id.sign_btn)
        val name = view.findViewById<EditText>(R.id.user_edit_text)
        val email = view.findViewById<EditText>(R.id.email_edit_text)
        val password = view.findViewById<EditText>(R.id.password_edit_text)

        signUpBtn.setOnClickListener(
            View.OnClickListener {
                signup(requireContext(), view.findNavController(),
                        name.text.toString(), email.text.toString(),
                        password.text.toString(), )
            }
        )

        return view
    }

    private fun signup(context: Context, nav: NavController,name: String, email: String, password: String) {
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val userInfo = User("", name, email, password)
        retIn.registerUser(userInfo).enqueue(object : Callback<ResponseBody> {
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
                    val bundle = bundleOf("user" to user)
                    nav.navigate(R.id.action_signUpFragment_to_mainFragment, bundle)
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