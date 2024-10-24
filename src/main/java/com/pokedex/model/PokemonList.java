package com.pokedex.model;

import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
public class PokemonList {
    private List<PokemonSummary> results;

    @Data
    public static class PokemonSummary {
        private String name;
        private String url;
        @Setter
        private PokemonDetail.Sprites sprites;


        @Data
        public static class Sprites {
            private String front_default;
            private String front_shiny;
        }
    }
}

