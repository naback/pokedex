package com.pokedex.services;

import com.pokedex.db.Pokemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseServiceTest {
    private BaseService service;

    @Test
    public void nullOrEmptyTest_null() {
        // arrange
        service = new BaseService();
        String valueToTest = null;

        // act
        System.out.println("service: " + service);
        var result = service.nullOrEmpty(valueToTest);

        // assert
        Assertions.assertEquals(true, result);
    }

    @Test
    public void nullOrEmptyTest_empty() {
        // arrange
        service = new BaseService();
        String valueToTest = "";

        // act
        System.out.println("service: " + service);
        var result = service.nullOrEmpty(valueToTest);

        // assert
        Assertions.assertEquals(true, result);
    }

    @Test
    public void nullOrEmptyTest_hasData() {
        // arrange
        service = new BaseService();
        String valueToTest = "testData";

        // act
        var result = service.nullOrEmpty(valueToTest);

        // assert
        Assertions.assertEquals(false, result);
    }

    @Test
    public void checkRetrievedDataTest_notThrow() throws Exception {
        // arrange
        service = new BaseService();
        Pokemon pokemon = new Pokemon();
        String pokemonRequested = "Charizard";

        // act
        Assertions.assertDoesNotThrow(() -> {service.checkRetrievedData(pokemon, pokemonRequested);});
    }

    @Test
    public void checkRetrievedDataTest_throw() throws Exception {
        // arrange
        service = new BaseService();
        Pokemon pokemon = null;
        String pokemonRequested = "Charizard";

        // act
        Assertions.assertThrows(Exception.class, () -> {service.checkRetrievedData(pokemon, pokemonRequested);});
    }
}
