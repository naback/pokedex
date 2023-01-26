package com.pokedex.controllers;

import com.pokedex.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pokemon")
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

    // todo implement call in services
}
