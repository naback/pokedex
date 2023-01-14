package com.pokedex.db;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Pokemon {
    @Id
    private Long id;
    private String name;
    private int attack;
    private int defense;
    private int stamina;

}
