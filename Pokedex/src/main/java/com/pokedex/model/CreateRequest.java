package com.pokedex.model;

public class CreateRequest {
    private Long id;
    private String name;
    private Integer attack;
    private Integer defense;
    private Integer stamina;

    CreateRequest() {
        this.id = null;
        this.name = null;
        this.attack = null;
        this.defense = null;
        this.stamina = null;
    }

    public CreateRequest(Long id, String name, Integer attack, Integer defense, Integer stamina) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }
}
