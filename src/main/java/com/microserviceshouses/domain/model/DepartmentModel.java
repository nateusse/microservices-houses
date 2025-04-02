package com.microserviceshouses.domain.model;



import java.util.Objects;

import static com.microserviceshouses.domain.utils.validations.Validation.validateDescription;
import static com.microserviceshouses.domain.utils.validations.Validation.validateName;


public class DepartmentModel {

    private Long id;
    private String name;
    private String description;

    public DepartmentModel(Long id, String name, String description) {
        this.name = validateName(name, "Department name", 50);
        this.description = validateDescription(description, "Department description", 120);
        this.id = id;
    }

    public DepartmentModel(Long id) {
        this.id = Objects.requireNonNull(id, "Department ID must not be null");
    }

    public void setName(String name) {
        this.name = validateName(name, "Department name", 50);
    }

    public void setDescription(String description) {
        this.description = validateDescription(description, "Department description", 120);
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }





}
