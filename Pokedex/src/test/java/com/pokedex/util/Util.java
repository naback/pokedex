package com.pokedex.util;

import com.pokedex.db.Pokemon;
import com.pokedex.model.CreateRequest;
import com.pokedex.model.DeleteRequest;

public final class Util {

    public static CreateRequest generateCreateRequest() {
        Long id = 1l;
        String name = "Charizard";
        Integer attack = 100;
        Integer defense = 100;
        Integer stamina = 100;

        return new CreateRequest(id, name, attack, defense, stamina);
    }

    public static DeleteRequest generateDeleteRequest() {
        long id = 1l;
        String name = "Charizard";

        return new DeleteRequest(id, name);
    }

    public static Pokemon generateMappedPokemonFromRequest(CreateRequest request) {
        return new Pokemon(request.getId(), request.getName(),
                request.getAttack(), request.getDefense(), request.getStamina());
    }
}
