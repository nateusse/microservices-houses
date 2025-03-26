package com.microserviceshouses.category.domain.ports.out;

import com.microserviceshouses.category.domain.model.CategoryModel;



public interface CategoryPersistencePort {
    void save(CategoryModel categoryModel);

}