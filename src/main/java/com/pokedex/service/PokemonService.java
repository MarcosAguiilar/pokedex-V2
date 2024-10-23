package com.pokedex.service;

import com.pokedex.model.PokemonDetail;
import com.pokedex.model.PokemonList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Objects;

@Service
public class PokemonService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<PokemonList.PokemonSummary> getAllPokemons1gen() {
        String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon?limit=151";
        PokemonList pokemonList = restTemplate.getForObject(POKEAPI_URL, PokemonList.class);
        return Objects.requireNonNull(pokemonList).getResults();
    }

    public PokemonDetail getPokemonDetails(String id) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + id; // Ajusta la URL para obtener detalles
        return restTemplate.getForObject(url, PokemonDetail.class);
    }



}
