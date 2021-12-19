package com.exemple.exo_quatre

import java.io.Serializable

class Pharmacy(
    val img: Int,
    val name: String,
    val adresse: String,
    val phone: String,
    val localisation: String,
    val heureOuvert: String,
    val heureFerme: String,
    val textDescr: String,
    val UrlFace:String,

) : Serializable