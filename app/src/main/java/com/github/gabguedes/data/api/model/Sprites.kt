package com.github.gabguedes.data.api.model

import com.google.gson.annotations.SerializedName

data class Sprites (
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("back_shiny") val backShiny: String?
)
