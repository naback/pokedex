package com.pokedex.model;

public class DeleteServiceRequest {
    private final Long id;
    private final String name;

    DeleteServiceRequest() {
        this.id = null;
        this.name = null;
    }

    public DeleteServiceRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
