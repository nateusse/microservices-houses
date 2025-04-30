package com.microserviceshouses.domain.usecases;

import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.ports.in.CategoryServicePort;
import com.microserviceshouses.domain.ports.out.CategoryPersistencePort;


public class CategoryUseCase implements CategoryServicePort {
    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void save(CategoryModel categoryModel) {

        categoryPersistencePort.save(categoryModel);
    }



}
