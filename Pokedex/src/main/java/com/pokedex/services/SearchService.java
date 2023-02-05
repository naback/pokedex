package com.pokedex.services;

import com.pokedex.db.Pokemon;
import com.pokedex.db.PokemonRepository;
import com.pokedex.mappers.PokemonMapper;
import com.pokedex.model.BaseResponse;
import com.pokedex.model.PokemonToReturn;
import com.pokedex.model.SearchResponse;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SearchService extends BaseService {
    public static final Logger logger = LoggerFactory.getLogger(CreateService.class);
    @Autowired
    private PokemonRepository pokemonRepository;

    private PokemonMapper pokemonMapper
            = Mappers.getMapper(PokemonMapper.class);

    public ResponseEntity search(String pokemonRequested) {
        try {
            logger.info("starting search service");

            checkSearchRequestData(pokemonRequested);
            Pokemon pokemon = searchRequestedPokemon(pokemonRequested);
            checkRetrievedData(pokemon, pokemonRequested);
            PokemonToReturn pokemonToReturn = mapFromPokemonToPokemonToReturn(pokemon);

            logger.info("search service finished with success");
            return ResponseEntity.status(200).body(new SearchResponse(pokemonToReturn));
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(400).body(new BaseResponse(e.getMessage()));
        }
    }

    private PokemonToReturn mapFromPokemonToPokemonToReturn(Pokemon pokemon) {
        return pokemonMapper.pokemonToPokemonToReturn(pokemon);
    }

    private void checkRetrievedData(Pokemon pokemon, String pokemonRequested) throws Exception {
        if (pokemon == null) {
            throw new Exception("Pokemon requested " + pokemonRequested + " not found in database!");
        }
    }

    private Pokemon searchRequestedPokemon(String pokemonRequested) {
        return pokemonRepository.findByName(pokemonRequested);
    }

    private void checkSearchRequestData(String pokemon) throws Exception {
        if (nullOrEmpty(pokemon)) {
            throw new Exception("Parameter name is null! It can't be!");
        }
    }
}
