package com.github.gabguedes.data.api.model

data class PokemonResponse(
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: Sprites
)