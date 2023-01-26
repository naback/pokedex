package com.pokedex.services;

import com.pokedex.db.Pokemon;
import com.pokedex.db.PokemonRepository;
import com.pokedex.mappers.PokemonMapper;
import com.pokedex.model.BaseResponse;
import com.pokedex.model.CreateRequest;
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
            return ResponseEntity.status(400).body(new BaseResponse(e.getMessage()));
        }
    }

    private Pokemon mapFromRequestToDbObject(CreateRequest request) {
        return PokemonMapper.INSTANCE.createRequestToPokemon(request);
    }

    private void checkCreateRequestData(CreateRequest request) throws Exception {
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
