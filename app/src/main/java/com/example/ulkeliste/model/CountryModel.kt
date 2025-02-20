package com.example.ulkeliste.model

import kotlinx.serialization.Serializable


@Serializable
data class CountryModel(
    val unMember: Boolean? = null,
    val name: Name? = null
)
@Serializable
data class Name(
    val common: String? = null,
    val official: String? = null,
    val nativeName: NativeName? = null
)
@Serializable
data class NativeName(
    val eng: Eng? = null
)
@Serializable
data class Eng(
    val official: String? = null,
    val common: String? = null
)





