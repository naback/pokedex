package com.pokedex.services;

import com.pokedex.db.Pokemon;
import com.pokedex.db.PokemonRepository;
import com.pokedex.model.BaseResponse;
import com.pokedex.model.UpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateService extends BaseService {

    public static final Logger logger = LoggerFactory.getLogger(UpdateService.class);
    @Autowired
    private PokemonRepository pokemonRepository;

    public ResponseEntity update(String pokemonToUpdate, UpdateRequest request) {
        try {
            logger.info("starting update service");

            checkUpdateData(pokemonToUpdate, request);
            Pokemon pokemon = pokemonRepository.findByName(pokemonToUpdate);
            checkRetrievedData(pokemon, pokemonToUpdate);
            updatePokemonData(request, pokemon);

            logger.info("update service finished with success");
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(400).body(new BaseResponse(e.getMessage()));
        }
    }

    protected void updatePokemonData(UpdateRequest request, Pokemon pokemon) {
        boolean changed = false;

        if (!nullOrEmpty(request.getName())) {
            pokemon.setName(request.getName());
            changed = true;
        }

        if (request.getAttack() != null) {
            pokemon.setAttack(request.getAttack());
            changed = true;
        }

        if (request.getDefense() != null) {
            pokemon.setDefense(request.getDefense());
            changed = true;
        }

        if (request.getStamina() != null) {
            pokemon.setStamina(request.getStamina());
            changed = true;
        }

        if (changed) {
            pokemonRepository.save(pokemon);
        }
    }

    protected void checkUpdateData(String pokemonToUpdate, UpdateRequest request) throws Exception {
        if (nullOrEmpty(pokemonToUpdate)) {
            throw new Exception("There was no pokemon name received as parameter in the url. There must be one!");
        }

        if (request == null) {
            throw new Exception("The request is null! It can't be!");
        }

        if (allUpdateRequestParametersAreNull(request)) {
            throw new Exception("All parameters in the request are null. There is nothing to update!");
        }
    }

    protected boolean allUpdateRequestParametersAreNull(UpdateRequest request) {
        if ((request.getName() == null) && (request.getAttack() == null) && (request.getDefense() == null) && (request.getStamina() == null)) {
            return true;
        }

        else {
            return false;
        }
    }
}
