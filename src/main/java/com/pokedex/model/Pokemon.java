package com.pokedex.model;

import lombok.Data;

import java.util.List;

@Data
public class Pokemon {
    private int id; // ID único del Pokémon
    private String name; // Nombre del Pokémon
    private String url; // URL de más información
    private float height; // Altura del Pokémon
    private float weight; // Peso del Pokémon
    private Sprites sprites; // Para las imágenes del Pokémon
    private List<Type> types; // Para los tipos del Pokémon
    private List<Ability> abilities; // Para las habilidades del Pokémon

    // Clases internas para Sprites, Type y Ability
    @Data
    public static class Sprites {
        private String front_default; // Imagen frontal
    }

    @Data
    public static class Type {
        private TypeDetails type; // Detalles del tipo
    }

    @Data
    public static class TypeDetails {
        private String name; // Nombre del tipo
    }

    @Data
    public static class Ability {
        private AbilityDetails ability; // Detalles de la habilidad
    }

    @Data
    public static class AbilityDetails {
        private String name; // Nombre de la habilidad
    }
}
