package com.microserviceshouses.locations.domain.model;

import com.microserviceshouses.locations.domain.exceptions.
        DescriptionMaxSizeExceededException;
import com.microserviceshouses.locations.domain.exceptions.NameMaxSizeExceededException;
import com.microserviceshouses.locations.domain.utils.constants.DomainConstants;

import java.util.Objects;

public class LocationModel {

    private Long id;
    private String city;
    private String department;
    private String descriptionCity;
    private String descriptionDepartment;

    public LocationModel(Long id, String city, String department, String descriptionCity, String descriptionDepartment) {
        validateName(city);
        validateName(department);
        validateDescription(descriptionCity);
        validateDescription(descriptionDepartment);

        this.id = id;
        this.city = Objects.requireNonNull(city, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.department = Objects.requireNonNull(department, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.descriptionCity = Objects.requireNonNull(descriptionCity, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        this.descriptionDepartment = Objects.requireNonNull(descriptionDepartment, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(DomainConstants.FIELD_NAME_NULL_MESSAGE);
        }
        if (name.length() > DomainConstants.MAX_NAME_LENGTH) {
            throw new NameMaxSizeExceededException();
        }
    }

    private void validateDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException(DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        }
        if (description.length() > DomainConstants.MAX_DESCRIPTION_LENGTH) {
            throw new DescriptionMaxSizeExceededException();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        validateName(city);
        this.city = Objects.requireNonNull(city, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        validateName(department);
        this.department = Objects.requireNonNull(department, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public String getDescriptionCity() {
        return descriptionCity;
    }

    public void setDescriptionCity(String descriptionCity) {
        validateDescription(descriptionCity);
        this.descriptionCity = Objects.requireNonNull(descriptionCity, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public String getDescriptionDepartment() {
        return descriptionDepartment;
    }

    public void setDescriptionDepartment(String descriptionDepartment) {
        validateDescription(descriptionDepartment);
        this.descriptionDepartment = Objects.requireNonNull(descriptionDepartment, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }


}
