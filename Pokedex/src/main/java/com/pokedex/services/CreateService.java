package com.pokedex.services;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.pokedex.db.Pokemon;
import com.pokedex.db.PokemonRepository;
import com.pokedex.mappers.PokemonMapper;
import com.pokedex.model.BaseResponse;
import com.pokedex.model.CreateRequest;
import com.pokedex.model.MissingParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateService extends BaseService {
    @Autowired
    private PokemonRepository pokemonRepository;

    public ResponseEntity create(CreateRequest request) {
        try {
            checkCreateRequestData(request);
            Pokemon pokemon = mapFromRequestToDbObject(request);
            pokemonRepository.save(pokemon);
            return ResponseEntity.status(200).build();
        }
        catch (MissingParameterException me) {
            return ResponseEntity.status(400).body(new BaseResponse(me.getErrorMessage()));
        }
    }

    private Pokemon mapFromRequestToDbObject(CreateRequest request) {
        return PokemonMapper.INSTANCE.createRequestToPokemon(request);
    }

    private void checkCreateRequestData(CreateRequest request) throws MissingParameterException {
        if (nullOrEmpty(request.getName())) {
            throw new MissingParameterException("Parameter name is null! It can't be!");
        }

        if (request.getAttack() == null) {
            throw new MissingParameterException("Parameter attack is null! It can't be!");
        }

        if (request.getDefense() == null) {
            throw new MissingParameterException("Parameter defense is null! It can't be!");
        }

        if (request.getStamina() == null) {
            throw new MissingParameterException("Parameter stamina is null! It can't be!");
        }
    }
}
