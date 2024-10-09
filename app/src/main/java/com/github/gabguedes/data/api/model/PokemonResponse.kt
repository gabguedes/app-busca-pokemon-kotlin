package com.github.gabguedes.data.api.model

data class PokemonResponse(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: Sprites
)