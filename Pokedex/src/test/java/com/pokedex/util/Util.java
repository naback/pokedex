package com.pokedex.util;

import com.pokedex.db.Pokemon;
import com.pokedex.model.*;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

public final class Util {

    public static CreateRequest generateCreateRequest() {
        Long id = 1l;
        String name = "Charizard";
        Integer attack = 100;
        Integer defense = 100;
        Integer stamina = 100;

        return new CreateRequest(id, name, attack, defense, stamina);
    }

    public static PokemonToReturn generateCharizardAsPokemonToReturn() {
        Long id = 1l;
        String name = "Charizard";
        Integer attack = 100;
        Integer defense = 100;
        Integer stamina = 100;

        return new PokemonToReturn(id, name, attack, defense, stamina);
    }

    public static Pokemon generateCharizard() {
        Long id = 1l;
        String name = "Charizard";
        Integer attack = 100;
        Integer defense = 100;
        Integer stamina = 100;

        return new Pokemon(id, name, attack, defense, stamina);
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

    public static List<Pokemon> getPokemonsDatabaseMockList() {
        var pokemon1 = new Pokemon(1l, "Charizard", 100, 100, 100);
        var pokemon2 = new Pokemon(2l, "Pikachu", 50, 50, 50);
        var pokemon3 = new Pokemon(3l, "Bulbassaur", 70, 70, 70);

        return Arrays.asList(pokemon1, pokemon2, pokemon3);
    }

    public static ResponseEntity generateListResponse(List<Pokemon> pokemonsMockListFromDatabase) {
        return ResponseEntity.status(200).body(new ListResponse(pokemonsMockListFromDatabase));
    }

    public static UpdateRequest createUpdateRequest() {
        String name = null;
        Integer attack = 300;
        Integer defense = 300;
        Integer stamina = 300;
        return new UpdateRequest(name, attack, defense, stamina);
    }
}
