package com.pokedex.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
public class SearchResponse {
    private final PokemonToReturn pokemon;

    SearchResponse() {
        this.pokemon = null;
    }
}
