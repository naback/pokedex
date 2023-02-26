package com.pokedex.services;

import com.pokedex.db.PokemonRepository;
import com.pokedex.model.BaseResponse;
import com.pokedex.model.DeleteRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteService extends BaseService {
    public static final Logger logger = LoggerFactory.getLogger(DeleteService.class);
    @Autowired
    private PokemonRepository pokemonRepository;

    public ResponseEntity delete(DeleteRequest request) {
        try {
            logger.info("starting delete service");

            checkDeleteRequestData(request);
            deleteByIdOrName(request);

            logger.info("delete service finished with success");
            return ResponseEntity.status(200).build();
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(400).body(new BaseResponse(e.getMessage()));
        }
    }

    protected void deleteByIdOrName(DeleteRequest request) {
        if (request.getId() != null) {
            pokemonRepository.deleteById(request.getId());
        }
        else {
            pokemonRepository.deleteByName(request.getName());
        }
    }

    protected void checkDeleteRequestData(DeleteRequest request) throws Exception {
        if ((request.getId() == null) && (nullOrEmpty(request.getName()))) {
            throw new Exception("id and name cant both be null, at least one is needed");
        }
    }
}
