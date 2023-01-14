package com.pokedex.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class BaseResponse {
    private final String status;

    BaseResponse() {
        this.status = null;
    }
}
