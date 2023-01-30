package com.pokedex.services;

import com.google.gson.Gson;
import com.pokedex.db.Pokemon;
import com.pokedex.db.PokemonRepository;
import com.pokedex.mappers.PokemonMapper;
import com.pokedex.model.BaseResponse;
import com.pokedex.model.CreateRequest;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateService extends BaseService {

    public static final Logger logger = LoggerFactory.getLogger(CreateService.class);
    @Autowired
    private PokemonRepository pokemonRepository;

    private PokemonMapper pokemonMapper
            = Mappers.getMapper(PokemonMapper.class);

    public ResponseEntity create(CreateRequest request) {
        try {
            logger.info("starting create service");

            checkCreateRequestData(request);
            Pokemon pokemon = mapFromRequestToDbObject(request);
            pokemonRepository.save(pokemon);

            logger.info("create service finished with success");
            return ResponseEntity.status(200).build();
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(400).body(new BaseResponse(e.getMessage()));
        }
    }

    private Pokemon mapFromRequestToDbObject(CreateRequest request) {
        return pokemonMapper.createRequestToPokemon(request);
    }

    private void checkCreateRequestData(CreateRequest request) throws Exception {
        if (request.getId() == null) {
            throw new Exception("Parameter name is null! It can't be!");
        }

        if (nullOrEmpty(request.getName())) {
            throw new Exception("Parameter name is null! It can't be!");
        }

        if (request.getAttack() == null) {
            throw new Exception("Parameter attack is null! It can't be!");
        }

        if (request.getDefense() == null) {
            throw new Exception("Parameter defense is null! It can't be!");
        }

        if (request.getStamina() == null) {
            throw new Exception("Parameter stamina is null! It can't be!");
        }
    }
}
