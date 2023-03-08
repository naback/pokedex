package com.pokedex.services;

import com.pokedex.db.PokemonRepository;
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
public class UpdateServiceTest {
    @InjectMocks
    private UpdateService service;

    @Mock
    private PokemonRepository repository;

    @Test
    public void update() {

        // arrange
        var request = Util.createUpdateRequest();
        var pokemonToUpdate = "Charizard";
        var response = ResponseEntity.status(200).build();
        var charizard = Util.generateCharizard();
        Mockito.when(repository.findByName(pokemonToUpdate)).thenReturn(charizard);
        charizard.setAttack(request.getAttack());
        charizard.setDefense(request.getDefense());
        charizard.setStamina(request.getStamina());
        Mockito.when(repository.save(charizard)).thenReturn(charizard);

        // act and assert
        Assertions.assertEquals(response.getStatusCode(), service.update(pokemonToUpdate, request).getStatusCode());
    }
}
