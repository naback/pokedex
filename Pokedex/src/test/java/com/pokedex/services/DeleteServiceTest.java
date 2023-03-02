package com.pokedex.services;

import com.pokedex.db.PokemonRepository;
import com.pokedex.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class DeleteServiceTest {
    @InjectMocks
    private DeleteService service;

    @Mock
    private PokemonRepository repository;

    @Test
    public void delete() {
        // arrange
        var request = Util.generateDeleteRequest();
        var response = ResponseEntity.status(200).build();
//        Mockito.doNothing().when(Mockito.mock(PokemonRepository.class)).deleteById(request.getId());   // unecessary stub

        // act and assert
        Assertions.assertEquals(HttpStatus.OK, service.delete(request).getStatusCode());
        Assertions.assertEquals(response, service.delete(request));
    }

    @Test
    public void deleteByIdOrName() {
        // arrange
        var request = Util.generateDeleteRequest();

        // act and assert
        Assertions.assertDoesNotThrow(() -> service.deleteByIdOrName(request));
    }

    @Test
    public void checkDeleteRequestData() {
        // arrange
        var request = Util.generateDeleteRequest();

        // act and assert
        Assertions.assertDoesNotThrow(() -> service.checkDeleteRequestData(request));
    }
}
