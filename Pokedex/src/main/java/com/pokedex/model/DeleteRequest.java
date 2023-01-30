package com.pokedex.model;

public class DeleteRequest {
    private final Long id;
    private final String name;

    DeleteRequest() {
        this.id = null;
        this.name = null;
    }

    public DeleteRequest(Long id, String name) {
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
