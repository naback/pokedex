package com.pokedex.mappers;

import com.pokedex.db.Pokemon;
import com.pokedex.model.CreateRequest;
import com.pokedex.model.PokemonToReturn;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PokemonMapper {
    Pokemon createRequestToPokemon(CreateRequest request);

    PokemonToReturn pokemonToPokemonToReturn(Pokemon pokemon);
}
