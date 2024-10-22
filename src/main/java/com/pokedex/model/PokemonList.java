package com.pokedex.model;

import lombok.Data;

import java.util.List;

@Data
public class PokemonList {
    private List<PokemonSummary> results;

    @Data
    public static class PokemonSummary {
        private String name; // Nombre del Pokémon
        private String url; // URL para obtener más información
    }
}

