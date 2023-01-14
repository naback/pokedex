package com.pokedex.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class UpdateRequest {
    private final Long id;
    private final String name;
    private final Integer attack;
    private final Integer defense;
    private final Integer stamina;

    UpdateRequest() {
        this.id = null;
        this.name = null;
        this.attack = null;
        this.defense = null;
        this.stamina = null;
    }
}
