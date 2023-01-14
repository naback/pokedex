package com.pokedex.model;

import com.pokedex.db.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class ListResponse {
    private final List<Pokemon> allPokemons;

    ListResponse() {
        this.allPokemons = null;
    }
}
