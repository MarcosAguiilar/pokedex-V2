package com.pokedex.service;

import com.pokedex.model.Pokemon;
import com.pokedex.model.PokemonList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokemonService {
    private final String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon?limit=151"; // Puedes ajustar el límite según sea necesario
    private final RestTemplate restTemplate;

    public PokemonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<PokemonList.PokemonSummary> getAllPokemons() {
        PokemonList pokemonList = restTemplate.getForObject(POKEAPI_URL, PokemonList.class);
        return pokemonList.getResults();
    }


    public Pokemon getPokemonById(int id) {
        return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + id, Pokemon.class);
    }

    public Pokemon getPokemonDetails(String url) {
        return restTemplate.getForObject(url, Pokemon.class);
    }

}
