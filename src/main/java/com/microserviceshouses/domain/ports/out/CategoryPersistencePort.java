package com.microserviceshouses.domain.ports.out;

import com.microserviceshouses.domain.model.CategoryModel;



public interface CategoryPersistencePort {
    void save(CategoryModel categoryModel);

    boolean existsByName(String name);
}