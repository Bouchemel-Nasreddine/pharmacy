package com.exemple.exo_quatre.data

import java.io.Serializable

class Pharmacy(
    val img: Int,
    val name: String,
    val adresse: String,
    val phone: String,
    val localisation: String,
    val coordinates: Pair<Double, Double>,
    val heureOuvert: String,
    val heureFerme: String,
    val textDescr: String,
    val UrlFace:String,

) : Serializable