package com.pokedex.db;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pokemon {
    @Id
    private Long id;
    private String name;
    private Integer attack;
    private Integer defense;
    private Integer stamina;

    public Pokemon() {
        this.id = null;
        this.name = null;
        this.attack = null;
        this.defense = null;
        this.stamina = null;
    }

    public Pokemon(Long id, String name, Integer attack, Integer defense, Integer stamina) {
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
