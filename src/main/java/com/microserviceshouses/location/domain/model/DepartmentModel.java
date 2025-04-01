package com.microserviceshouses.location.domain.model;

public class DepartmentModel {

    private Long id;
    private String DepartmentName;

    private String DepartmentDescription;

    public DepartmentModel(Long id, String name, String description) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Not empty deparment name, lazy MTF");
        }
        if (name.length() > 50) {
            throw new IllegalArgumentException("No more than 50 words, not an essay");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Not empty deparment  description, lazy MTF");
        }
        if (description.length() > 120) {
            throw new IllegalArgumentException("Description too long, talk to a therapist");
        }

        this.id = id;
        this.DepartmentName = DepartmentName;
        this.DepartmentDescription = DepartmentDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return DepartmentName;
    }

    public void setName(String DepartmentName) {
        this.DepartmentName= DepartmentName;
    }

    public String getDepartmentDescription() {
        return DepartmentDescription;
    }

    public void setDepartmentDescription(String DepartmentDescription) {
        if (DepartmentDescription.length() > 120) throw new IllegalArgumentException("Description too long, talk to a therapist");
        this.DepartmentDescription = DepartmentDescription;
    }
}