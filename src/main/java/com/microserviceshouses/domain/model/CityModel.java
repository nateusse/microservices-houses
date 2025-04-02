package com.microserviceshouses.domain.model;

import java.util.Objects;
import java.util.UUID;

import static com.microserviceshouses.domain.utils.validations.Validation.validateDescription;
import static com.microserviceshouses.domain.utils.validations.Validation.validateName;

public class CityModel {

    private UUID id;;
    private String name;
    private String description;
    private DepartmentModel department;

    public CityModel(UUID id, String name, String description, DepartmentModel department) {
        this.name = validateName(name, "City name", 50);
        this.description = validateDescription(description, "City description", 120);
        this.department = Objects.requireNonNull(department, "City must belong to a department");
        this.id = id;
    }

    public void setName(String name) {
        this.name = validateName(name, "City name", 50);
    }

    public void setDescription(String description) {
        this.description = validateDescription(description, "City description", 120);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public DepartmentModel getDepartment() {
        return department;
    }
}