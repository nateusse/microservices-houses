package com.microserviceshouses.domain.model;


import com.microserviceshouses.domain.exceptions.CityDepartmentDescriptionMaxSizeExceededException;
import com.microserviceshouses.domain.exceptions.CityDepartmentNameMaxSizeExceededException;
import com.microserviceshouses.domain.utils.constants.DomainConstants;

import java.util.Objects;

public class CityDepartmentModel {

    private Long id;
    private String name;
    private String description;

    public CityDepartmentModel(Long id, String name, String description) {
        if (name.length() > 50) throw new CityDepartmentNameMaxSizeExceededException();
        if (description.length() > 90) throw new CityDepartmentDescriptionMaxSizeExceededException();
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
        if (name.length() > 50) throw new CityDepartmentNameMaxSizeExceededException();
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length() > 90) throw new CityDepartmentDescriptionMaxSizeExceededException();
        this.description = Objects.requireNonNull(description,  DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

}
