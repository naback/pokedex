package com.pokedex.model;

public class UpdateRequest {
    private final String name;
    private final Integer attack;
    private final Integer defense;
    private final Integer stamina;

    UpdateRequest() {
        this.name = null;
        this.attack = null;
        this.defense = null;
        this.stamina = null;
    }

    public UpdateRequest(String name, Integer attack, Integer defense, Integer stamina) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.stamina = stamina;
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
