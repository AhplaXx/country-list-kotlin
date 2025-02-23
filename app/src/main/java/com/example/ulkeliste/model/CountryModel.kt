package com.example.ulkeliste.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class CountryModel(
    val unMember: Boolean? = null,
    val name: Name? = null,
    val population: Int? = null,
    val flags: Flag? = null,
) : Parcelable

@Serializable
@Parcelize
data class Name(
    val common: String? = null,
    val official: String? = null,
    val nativeName: NativeName? = null,
) : Parcelable

@Serializable
@Parcelize
data class NativeName(
    val eng: Eng? = null
) : Parcelable

@Serializable
@Parcelize
data class Eng(
    val official: String? = null,
    val common: String? = null
) : Parcelable

@Serializable
@Parcelize
data class Flag(
    val png: String? = null,
    val svg: String? = null,
) : Parcelable



