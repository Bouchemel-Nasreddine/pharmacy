package com.exemple.exo_quatre

import com.exemple.exo_quatre.data.SignInData
import com.exemple.exo_quatre.data.User
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers("Content-Type:application/json")
    @POST("login")
    fun signin(@Body info: SignInData): retrofit2.Call<ResponseBody>

    @Headers("Content-Type:application/json")
    @POST("register")
    fun registerUser(
        @Body info: User
    ): retrofit2.Call<ResponseBody>
}

class RetrofitInstance {
    companion object {
        private const val BASE_URL: String = "http://bae7-105-235-130-238.ngrok.io/api/user/"

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}