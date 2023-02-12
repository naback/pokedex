package com.pokedex.services;

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
        System.out.println("service: " + service);
        var result = service.nullOrEmpty(valueToTest);

        // assert
        Assertions.assertEquals(false, result);
    }
}
