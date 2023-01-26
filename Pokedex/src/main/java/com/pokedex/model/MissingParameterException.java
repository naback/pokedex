package com.pokedex.model;

public class MissingParameterException extends Exception{
    private final String errorMessage;

    MissingParameterException() {
        this.errorMessage = null;
    }

    public MissingParameterException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
