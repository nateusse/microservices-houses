package com.microserviceshouses.locations.domain.model;

import java.util.UUID;

public class LocationModel {
    private Long id;
    private final City city;
    private final Department department;

    public LocationModel(Long id, City city, Department department) {
        if (city == null || department == null) {
            throw new IllegalArgumentException("City and department must not be null.");
        }
        this.id = id;
        this.city = city;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { // Setter in case of JPA auto-generation
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public Department getDepartment() {
        return department;
    }





}
