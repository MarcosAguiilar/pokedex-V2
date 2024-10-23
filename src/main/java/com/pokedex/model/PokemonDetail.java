package com.pokedex.model;

import lombok.Data;

import java.util.List;

@Data
public class PokemonDetail {
    private String name;
    private int height;
    private int weight;
    private List<Ability> abilities;

    @Data
    public static class Ability {
        private String name;
    }
}
