package com.pokedex.services;

import com.pokedex.db.PokemonRepository;
import com.pokedex.model.ListResponse;
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
public class ListServiceTest {
    @InjectMocks
    private ListService service;

    @Mock
    private PokemonRepository repository;

    @Test
    public void list() {
        // arrange
        var pokemonsMockListFromDatabase = Util.getPokemonsDatabaseMockList();
        Mockito.when(repository.findAll()).thenReturn(pokemonsMockListFromDatabase);

        Assertions.assertEquals(HttpStatus.OK, service.list().getStatusCode());
        Assertions.assertEquals(pokemonsMockListFromDatabase, ((ListResponse) service.list().getBody()).getAllPokemons());
    }
}
