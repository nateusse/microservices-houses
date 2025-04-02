package com.microserviceshouses.domain.model;

import java.util.Objects;

public class CategoryModel {

    private Long id;
    private String name;
    private String description;

    public CategoryModel(Long id, String name, String description) {
        this.name = Objects.requireNonNull(name, "Name must not be null").trim();
        this.description = Objects.requireNonNull(description, "Description must not be null").trim();

        if (name.trim().isEmpty()) throw new RuntimeException("Name must not be empty");
        if (description.trim().isEmpty()) throw new RuntimeException("Description must not be empty");
        if (name.length() > 50) throw new RuntimeException("Name must not exceed 50 characters");
        if (description.length() > 90) throw new RuntimeException("Description must not exceed 90 characters");

        this.id = id;
    }

    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name must not be null").trim();
        if (name.isEmpty()) throw new RuntimeException("Name must not be empty");
        if (name.length() > 50) throw new RuntimeException("Name must not exceed 50 characters");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = Objects.requireNonNull(description, "Description must not be null").trim();
        if (description.isEmpty()) throw new RuntimeException("Description must not be empty");
        if (description.length() > 90) throw new RuntimeException("Description must not exceed 90 characters");
        this.description = description;
    }

}

