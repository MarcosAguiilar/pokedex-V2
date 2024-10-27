package com.pokedex.model;

import lombok.Data;

import java.util.List;

@Data
public class PokemonDetail {
    private int id;
    private String name;
    private int height;
    private int weight;
    private List<Ability> abilities;
    private List<Type> types;
    private Sprites sprites;
    private List<Stat> stats;


    @Data
    public static class Ability {
        private AbilityDetail ability;

        @Data
        public static class AbilityDetail {
            private String name;
        }
    }

    @Data
    public static class Type {
        private TypeDetail type;

        @Data
        public static class TypeDetail {
            private String name;
        }
    }

    @Data
    public static class Sprites {
        private String front_default;
        private String front_shiny;
    }

    @Data
    public static class Stat {
        private int base_stat;
        private StatDetail stat;

        @Data
        public static class StatDetail {
            private String name;
        }
    }
}

