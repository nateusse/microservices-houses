package com.microserviceshouses.domain.model;

import com.microserviceshouses.domain.exceptions.DescriptionMaxSizeExceededException;
import com.microserviceshouses.domain.exceptions.DescriptionNotEmptyException;
import com.microserviceshouses.domain.exceptions.NameMaxSizeExceededException;
import com.microserviceshouses.domain.exceptions.NameNotEmptyException;
import com.microserviceshouses.domain.utils.constants.DomainConstants;

import java.util.Objects;

import static com.microserviceshouses.domain.utils.constants.DomainConstants.*;

public class CategoryModel {

    private Long id;
    private String name;
    private String description;

    public CategoryModel(Long id, String name, String description) {

        if (name.trim().isEmpty()) throw new NameNotEmptyException();
        if (description.trim().isEmpty()) throw new DescriptionNotEmptyException();
        if (name.length() > CATEGORY_NAME_MAX_LENGTH ) throw new NameMaxSizeExceededException();
        if (description.length() > CATEGORY_DESCRIPTION_MAX_LENGTH) throw new DescriptionMaxSizeExceededException();
        this.name = Objects.requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE).trim();
        this.description = Objects.requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE).trim();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name must not be null").trim();
        if (name.isEmpty()) throw new NameNotEmptyException();
        if (name.length() > CATEGORY_NAME_MAX_LENGTH) throw new NameMaxSizeExceededException();
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = Objects.requireNonNull(description, "Description must not be null").trim();
        if (description.isEmpty()) throw new DescriptionNotEmptyException();
        if (description.length()  > CATEGORY_DESCRIPTION_MAX_LENGTH) throw new DescriptionMaxSizeExceededException();
        this.description = description;
    }

}

