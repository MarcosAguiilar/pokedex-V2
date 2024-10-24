package com.pokedex.controller;

import com.pokedex.model.PokemonDetail;
import com.pokedex.model.PokemonList;
import com.pokedex.service.PokemonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemons")
    public String getPokemonList(@RequestParam(defaultValue = "0") int page, Model model) {
        int limit = 50;
        int offset = page * limit;
        List<PokemonList.PokemonSummary> pokemons = pokemonService.getPokemonList(limit, offset);
        model.addAttribute("pokemons", pokemons);
        model.addAttribute("currentPage", page);
        return "pokemons";
    }


    @GetMapping("/pokemon/{id}")
    public String getPokemonDetails(@PathVariable String id, Model model) {
        PokemonDetail pokemonDetail = pokemonService.getPokemonDetails(id);
        model.addAttribute("pokemon", pokemonDetail);
        return "pokemonDetails";
    }

}



