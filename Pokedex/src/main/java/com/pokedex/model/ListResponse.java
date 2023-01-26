package com.pokedex.model;

import com.pokedex.db.Pokemon;

import java.util.List;

public class ListResponse {
    private final List<Pokemon> allPokemons;

    ListResponse() {
        this.allPokemons = null;
    }

    public ListResponse(List<Pokemon> allPokemons) {
        this.allPokemons = allPokemons;
    }

    public List<Pokemon> getAllPokemons() {
        return allPokemons;
    }
}
