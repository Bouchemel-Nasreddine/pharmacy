package com.exemple.exo_quatre.data

import java.io.Serializable

data class User(
    var id: String,
    var name: String,
    var email: String,
    var password: String,
) : Serializable