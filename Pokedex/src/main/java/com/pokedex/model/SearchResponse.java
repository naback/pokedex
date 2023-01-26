package com.pokedex.model;

public class SearchResponse {
    private final PokemonToReturn pokemon;

    SearchResponse() {
        this.pokemon = null;
    }

    public SearchResponse(PokemonToReturn pokemon) {
        this.pokemon = pokemon;
    }

    public PokemonToReturn getPokemon() {
        return pokemon;
    }
}
