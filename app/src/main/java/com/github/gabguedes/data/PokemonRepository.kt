package com.github.gabguedes.data

import com.github.gabguedes.data.api.PokemonAPI
import com.github.gabguedes.domain.Pokemon

class PokemonRepository(private val api: PokemonAPI) {

    suspend fun getPokemonData(id: Int): Pokemon {
        val response = api.getPokemon(id)
        val sprites = listOfNotNull(
            response.sprites.frontDefault,
            response.sprites.backDefault,
            response.sprites.frontShiny,
            response.sprites.backShiny,
        )

        var officialArtwork = "";

        if(response.sprites.officialArtwork.frontDefault != null){
            officialArtwork = response.sprites.officialArtwork.frontDefault

        }

        return Pokemon(
            response.id,
            response.name,
            response.height,
            response.weight,
            sprites,
            officialArtwork
        )
    }
}