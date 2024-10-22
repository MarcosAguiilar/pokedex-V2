package com.pokedex.controller;

import com.pokedex.model.Pokemon;
import com.pokedex.model.PokemonList;
import com.pokedex.service.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemons")
    public List<PokemonList.PokemonSummary> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }

    @GetMapping("/pokemon/{id}")
    public Pokemon getPokemonDetails(@PathVariable int id) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + id;
        return pokemonService.getPokemonDetails(url);
    }


}

