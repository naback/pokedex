package com.pokedex.util;

import com.pokedex.db.Pokemon;
import com.pokedex.model.CreateRequest;

public final class Util {

    public static CreateRequest generateCreateRequest() {
        Long id = 1l;
        String name = "Charizard";
        Integer attack = 100;
        Integer defense = 100;
        Integer stamina = 100;

        return new CreateRequest(id, name, attack, defense, stamina);
    }

    public static Pokemon generateMappedPokemonFromRequest(CreateRequest request) {
        return new Pokemon(request.getId(), request.getName(),
                request.getAttack(), request.getDefense(), request.getStamina());
    }
}
