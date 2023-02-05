package com.pokedex.controllers;

import com.pokedex.model.CreateRequest;
import com.pokedex.model.DeleteRequest;
import com.pokedex.model.UpdateRequest;
import com.pokedex.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    public static final Logger logger = LoggerFactory.getLogger(PokemonController.class);

    @Autowired
    private CreateService createService;

    @Autowired
    private DeleteService deleteService;

    @Autowired
    private ListService listService;

    @Autowired
    private UpdateService updateService;

    @Autowired
    private SearchService searchService;

    @PostMapping("/create")
    private ResponseEntity createPokemon(@RequestBody CreateRequest request) {
        return createService.create(request);
    }

    @PostMapping("/delete")
    private ResponseEntity deletePokemon(@RequestBody DeleteRequest request) {
        return deleteService.delete(request);
    }

    @GetMapping("/list")
    private ResponseEntity listPokemon() {
        return listService.list();
    }

    @GetMapping("/search")
    public ResponseEntity searchPokemon(@RequestParam String pokemon) {
        return searchService.search(pokemon);
    }

    @PostMapping("/update")
    public ResponseEntity updatePokemon(@RequestParam String pokemon, @RequestBody UpdateRequest request) {
        return updateService.update(pokemon, request);
    }
}
