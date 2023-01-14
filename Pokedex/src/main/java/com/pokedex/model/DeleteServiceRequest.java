package com.pokedex.model;

import com.pokedex.services.DeleteService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class DeleteServiceRequest {
    private final Long id;
    private final String name;

    DeleteServiceRequest() {
        this.id = null;
        this.name = null;
    }
}
