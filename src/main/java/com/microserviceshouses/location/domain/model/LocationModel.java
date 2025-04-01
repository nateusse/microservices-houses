package com.microserviceshouses.location.domain.model;

public class LocationModel {

    private Long id;
    private CityModel city;
    private DepartmentModel department;

    public LocationModel(Long id, CityModel city, DepartmentModel department) {

        if (city == null) {
            throw new IllegalArgumentException("No null city MTF");
        }
        if (department == null) {
            throw new IllegalArgumentException("No null deparment MTF");
        }

        this.id = id;
        this.city = city;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public CityModel getCity() {
        return city;
    }

    public DepartmentModel getDepartment() {
        return department;
    }
}
