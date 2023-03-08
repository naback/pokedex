package com.pokedex.services;

import com.pokedex.db.PokemonRepository;
import com.pokedex.model.UpdateRequest;
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

    @Test
    public void updatePokemonData() {

        // arrange
        var request = Util.createUpdateRequest();
        var charizard = Util.generateCharizard();

        // act
        service.updatePokemonData(request, charizard);

        // assert
        Assertions.assertEquals(300, charizard.getAttack());
        Assertions.assertEquals(300, charizard.getDefense());
        Assertions.assertEquals(300, charizard.getStamina());
    }

    @Test
    public void checkUpdateData() {
        // arrange
        var request = Util.createUpdateRequest();
        var pokemonToUpdate = "Charizard";

        // act and assert
        Assertions.assertDoesNotThrow(() -> service.checkUpdateData(pokemonToUpdate, request));
    }

    @Test
    public void checkUpdateData_throwException_pokemonToUpdateNull() {
        // arrange
        var request = Util.createUpdateRequest();
        String pokemonToUpdate = null;

        // act and assert
        Assertions.assertThrows(Exception.class, () -> service.checkUpdateData(pokemonToUpdate, request));
    }

    @Test
    public void checkUpdateData_throwException_requestNull() {
        // arrange
        UpdateRequest request = null;
        String pokemonToUpdate = "Charizard";

        // act and assert
        Assertions.assertThrows(Exception.class, () -> service.checkUpdateData(pokemonToUpdate, request));
    }

    @Test
    public void checkUpdateData_throwException_requestParametersNull() {
        // arrange
        UpdateRequest request = new UpdateRequest(null, null, null, null);
        String pokemonToUpdate = "Charizard";

        // act and assert
        Assertions.assertThrows(Exception.class, () -> service.checkUpdateData(pokemonToUpdate, request));
    }
}
