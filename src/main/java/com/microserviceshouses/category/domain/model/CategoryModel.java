package com.microserviceshouses.category.domain.model;

import java.util.Objects;

public class CategoryModel {
    private Long id;
    private String name;
    private String description;

    //TODO move exceptions to own class
    public CategoryModel(Long id, String name, String description) {
        if (name.length() > 50) throw new RuntimeException("Name must not exceed 50 characters");
        if (description.length() > 90)  throw new RuntimeException("Description must not exceed 90 characters");
        this.id = id;
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = Objects.requireNonNull(description,  DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 50)  throw new RuntimeException("Name must not exceed 50 characters");
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length() > 90)  throw new RuntimeException("Description must not exceed 90 characters");
        this.description = Objects.requireNonNull(description,  DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    //TODO move to wn class
    public static class DomainConstants {
        public static final String FIELD_NAME_NULL_MESSAGE = "Name must not be null";
        public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Description must not be null";
    }
}

