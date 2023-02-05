package com.pokedex.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.db.Pokemon;

public class BaseService {
    protected boolean nullOrEmpty(String value) {
        if ((value == null) || (value.isEmpty()))
            return true;

        else
            return false;
    }

    protected void checkRetrievedData(Pokemon pokemon, String pokemonRequested) throws Exception {
        if (pokemon == null) {
            throw new Exception("Pokemon requested " + pokemonRequested + " not found in database!");
        }
    }
}
