package com.task.calculadoradeimc

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Suppress("DEPRECATED_ANNOTATION")
@Parcelize

data class Data_Informations(

    var nome: String = "",
    var idade: String = "",
    var altura: String = "",
    var peso: String = "",
    var imc: Double = 0.0

) : Parcelable
