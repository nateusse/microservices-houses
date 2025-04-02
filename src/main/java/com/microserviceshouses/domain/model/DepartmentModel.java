package com.microserviceshouses.domain.model;

import java.util.UUID;

import static com.microserviceshouses.domain.utils.validations.Validation.validateDescription;
import static com.microserviceshouses.domain.utils.validations.Validation.validateName;


public class DepartmentModel {

    private UUID id;
    private String name;
    private String description;

    public DepartmentModel(UUID id, String name, String description) {
        this.name = validateName(name, "Department name", 50);
        this.description = validateDescription(description, "Department description", 120);
        this.id = id;
    }

    public void setName(String name) {
        this.name = validateName(name, "Department name", 50);
    }

    public void setDescription(String description) {
        this.description = validateDescription(description, "Department description", 120);
    }
    public String getName() {
        return name;
    }
    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
