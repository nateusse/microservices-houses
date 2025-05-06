package com.microserviceshouses.domain.model;


import com.microserviceshouses.domain.exceptions.CityDescriptionMaxSizeExceededException;
import com.microserviceshouses.domain.exceptions.CityNameMaxSizeExceededException;
import com.microserviceshouses.domain.utils.constants.DomainConstants;
import java.util.Objects;

public class CityModel {

    private Long id;
    private String name;
    private String description;
    private Long cityDepartmentId;

    public CityModel(Long id, String name, String description, Long cityDepartmentId) {
        if (name.length() > 50) throw new CityNameMaxSizeExceededException();
        if (description.length() > 90) throw new CityDescriptionMaxSizeExceededException();
        this.id = id;
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = Objects.requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
        this.cityDepartmentId = Objects.requireNonNull(cityDepartmentId, DomainConstants.FIELD_CITY_DEPARTMENT_ID_NULL_MESSAGE);
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
        if (name.length() > 50) throw new CityNameMaxSizeExceededException();
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length() > 90) throw new CityDescriptionMaxSizeExceededException();
        this.description = Objects.requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public Long getCityDepartmentId() {
        return cityDepartmentId;
    }

    public void setCityDepartmentId(Long cityDepartmentId) {
        this.cityDepartmentId = Objects.requireNonNull(cityDepartmentId, DomainConstants.FIELD_CITY_DEPARTMENT_ID_NULL_MESSAGE);
    }
}