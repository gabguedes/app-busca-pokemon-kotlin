package com.github.gabguedes.domain

import com.github.gabguedes.data.api.model.OfficialArtwork

data class Pokemon (
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val imagesURL: List<String>,
    val officialArtwork: String
)