package com.microserviceshouses.domain.usecases;

import com.microserviceshouses.domain.exceptions.CategoryAlreadyExistsException;
import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.model.pagination.PaginationRequestModel;
import com.microserviceshouses.domain.model.pagination.PaginationResponseModel;
import com.microserviceshouses.domain.ports.in.CategoryServicePort;
import com.microserviceshouses.domain.ports.out.CategoryPersistencePort;


public class CategoryUseCase implements CategoryServicePort {
    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void save(CategoryModel categoryModel) {
        String name = categoryModel.getName();
        CategoryModel category = categoryPersistencePort.getCategoryByName(name);
        if (category != null) {
            throw new CategoryAlreadyExistsException();
        }
        categoryPersistencePort.save(categoryModel);
    }

    @Override
    public PaginationResponseModel<CategoryModel> getCategories(PaginationRequestModel paginationRequestModel) {
        try {
            return categoryPersistencePort.getCategories(paginationRequestModel);
        }catch (Exception e) {
            throw new RuntimeException("Error retrieving categories", e);
        }
    }
}