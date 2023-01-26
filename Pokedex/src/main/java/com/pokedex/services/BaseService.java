package com.pokedex.services;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseService {
    public boolean nullOrEmpty(String value) {
        if ((value == null) || (value.isEmpty()))
            return true;

        else
            return false;
    }
}
