package com.pokedex.service;

import com.pokedex.model.PokemonDetail;
import com.pokedex.model.PokemonList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PokemonService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<PokemonList.PokemonSummary> getPokemonList(int limit, int offset) {
        // Hacemos la primera llamada para obtener la lista de Pokémon
        String url = "https://pokeapi.co/api/v2/pokemon?limit=" + limit + "&offset=" + offset;
        PokemonList pokemonList = restTemplate.getForObject(url, PokemonList.class);

        // Hacemos una segunda llamada para obtener los detalles de cada Pokémon
        List<PokemonList.PokemonSummary> detailedPokemonList = new ArrayList<>();

        for (PokemonList.PokemonSummary pokemon : Objects.requireNonNull(pokemonList).getResults()) {
            // Llamamos a la API con el nombre del Pokémon para obtener detalles (incluyendo sprites)
            String detailUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemon.getName();
            PokemonDetail details = restTemplate.getForObject(detailUrl, PokemonDetail.class);

            // Asignamos los sprites desde los detalles
            pokemon.setSprites(details.getSprites());

            // Agregamos el Pokémon con los detalles completos a la lista
            detailedPokemonList.add(pokemon);
        }

        return detailedPokemonList;
    }



    public PokemonDetail getPokemonDetails(String id) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + id;
        return restTemplate.getForObject(url, PokemonDetail.class);
    }





}
