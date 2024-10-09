package com.github.gabguedes.domain

data class Pokemon (
    val name: String,
    val height: Int,
    val weight: Int,
    val imagesURL: List<String>
)