package com.pokedex.services;

import com.pokedex.db.PokemonRepository;
import com.pokedex.mappers.PokemonMapper;
import com.pokedex.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CreateServiceTest {
    @InjectMocks
    private CreateService service;

    @Mock
    private PokemonRepository repository;

    @Mock
    private PokemonMapper mapper;

    @Test
    public void createTest_success() {
        // arrange
        var request = Util.generateCreateRequest();
        var pokemon = Util.generateMappedPokemonFromRequest(request);
        var response = ResponseEntity.status(200).build();
        Mockito.when(mapper.createRequestToPokemon(request)).thenReturn(pokemon);
        Mockito.when(repository.save(pokemon)).thenReturn(pokemon);

        // act and assert
        Assertions.assertEquals(response, service.create(request));
    }

    @Test
    public void checkRequestData_success() {
        var request = Util.generateCreateRequest();

        Assertions.assertDoesNotThrow(() -> service.checkCreateRequestData(request));
    }

    @Test
    public void checkRequestData_failure() {
        var request = Util.generateCreateRequest();
        request.setAttack(null);

        Assertions.assertThrows(Exception.class, () -> service.checkCreateRequestData(request));
    }
}
