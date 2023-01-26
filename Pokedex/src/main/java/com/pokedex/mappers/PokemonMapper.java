package com.pokedex.mappers;

import com.pokedex.db.Pokemon;
import com.pokedex.model.CreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PokemonMapper {
    PokemonMapper INSTANCE = Mappers.getMapper(PokemonMapper.class);
    Pokemon createRequestToPokemon(CreateRequest request);
}
