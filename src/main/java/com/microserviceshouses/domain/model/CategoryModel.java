package com.microserviceshouses.domain.model;

import com.microserviceshouses.domain.utils.constants.DomainConstants;

import java.util.Objects;

public class CategoryModel {

    private Long id;
    private String name;
    private String description;

    public CategoryModel(Long id, String name, String description) {
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = Objects.requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);

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
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        if (name.length() > 50) throw new RuntimeException("Name must not exceed 50 characters");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = Objects.requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        if (description.length() > 90) throw new RuntimeException("Description must not exceed 90 characters");
    }

}

