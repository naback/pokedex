package com.pokedex.services;

import com.pokedex.db.PokemonRepository;
import com.pokedex.model.BaseResponse;
import com.pokedex.model.DeleteRequest;
import com.pokedex.model.ListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ListService {
    public static final Logger logger = LoggerFactory.getLogger(ListService.class);
    @Autowired
    private PokemonRepository pokemonRepository;

    public ResponseEntity list() {
        try {
            logger.info("starting list service");

            var allPokemons = pokemonRepository.findAll();

            logger.info("list service finished with success");
            return ResponseEntity.status(200).body(new ListResponse(allPokemons));
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(400).body(new BaseResponse(e.getMessage()));
        }
    }
}
