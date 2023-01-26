package com.pokedex.model;

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

    public UpdateRequest(Long id, String name, Integer attack, Integer defense, Integer stamina) {
        this.id = id;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.stamina = stamina;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getStamina() {
        return stamina;
    }
}
