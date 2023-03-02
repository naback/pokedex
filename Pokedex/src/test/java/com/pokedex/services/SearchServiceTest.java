package com.pokedex.services;

import com.pokedex.db.PokemonRepository;
import com.pokedex.model.SearchResponse;
import com.pokedex.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @InjectMocks
    private SearchService service;

    @Mock
    private PokemonRepository repository;

    @Test
    public void search() {
        // arrange
        String pokemonRequested = "Charizard";
        var pokemon = Util.generateCharizard();
        var pokemonToReturn = Util.generateCharizardAsPokemonToReturn();
        Mockito.when(repository.findByName(pokemonRequested)).thenReturn(pokemon);

        // act and assert
        Assertions.assertEquals(HttpStatus.OK, service.search(pokemonRequested).getStatusCode());
        Assertions.assertEquals(pokemonToReturn.getId(), ((SearchResponse) service.search(pokemonRequested).getBody()).getPokemon().getId());
        Assertions.assertEquals(pokemonToReturn.getName(), ((SearchResponse) service.search(pokemonRequested).getBody()).getPokemon().getName());
        Assertions.assertEquals(pokemonToReturn.getAttack(), ((SearchResponse) service.search(pokemonRequested).getBody()).getPokemon().getAttack());
        Assertions.assertEquals(pokemonToReturn.getDefense(), ((SearchResponse) service.search(pokemonRequested).getBody()).getPokemon().getDefense());
        Assertions.assertEquals(pokemonToReturn.getStamina(), ((SearchResponse) service.search(pokemonRequested).getBody()).getPokemon().getStamina());
    }

    @Test
    public void checkDeleteRequestData() {
        // arrange
        String pokemonRequested = "Charizard";

        // act and assert
        Assertions.assertDoesNotThrow(() -> service.checkSearchRequestData(pokemonRequested));
    }
}
