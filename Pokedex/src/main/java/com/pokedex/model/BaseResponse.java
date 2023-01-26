package com.pokedex.model;

public class BaseResponse {
    private final String errorDescription;

    BaseResponse() {
        this.errorDescription = null;
    }

    public BaseResponse(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
