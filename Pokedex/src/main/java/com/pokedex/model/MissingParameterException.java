package com.pokedex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MissingParameterException extends Exception{
    private final String errorMessage;

    MissingParameterException() {
        this.errorMessage = null;
    }
}
