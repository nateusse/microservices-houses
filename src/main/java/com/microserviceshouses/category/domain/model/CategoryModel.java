package com.microserviceshouses.category.domain.model;

public class CategoryModel {
    private Long id;
    private String name;
    private String description;

    public CategoryModel(Long id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
    }


    public String getName() {
        return name;
    }
}