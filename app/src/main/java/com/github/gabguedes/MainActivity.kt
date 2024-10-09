package com.github.gabguedes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.github.gabguedes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainAdapter = MainAdapter()

        binding.rvSprites.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL, false
        )
        binding.rvSprites.adapter = mainAdapter

        viewModel.pokemonResponse.observe(this){ pokemon ->
            binding.tvPokemonName.text = pokemon.name
            binding.tvPokemonNumber.text = pokemon.id.toString()
            binding.tvPokemonHeight.text = pokemon.height.toString()
            mainAdapter.submitList(pokemon.imagesURL)
            setUpArtwork(pokemon.officialArtwork)
        }

        // Configurando o clique do botão de busca
        binding.btnSearch .setOnClickListener {
            val id = binding.etPokemonId .text.toString(). toIntOrNull()
            if (id != null) {
                viewModel.fetchPokemon(id)
            }
        }
    }

    private fun setUpArtwork(url: String) {
        Glide
            .with(this)
            .load(url).error("https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Pokebola-pokeball-png-0.png/640px-Pokebola-pokeball-png-0.png")
            .into(binding.ivPokemonImg)
    }
}