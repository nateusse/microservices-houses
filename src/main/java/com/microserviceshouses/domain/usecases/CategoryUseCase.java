package com.microserviceshouses.domain.usecases;

import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.model.PaginationRequest;
import com.microserviceshouses.domain.model.PaginationResponse;
import com.microserviceshouses.domain.ports.in.CategoryServicePort;
import com.microserviceshouses.domain.exceptions.CategoryAlreadyExistsException;
import com.microserviceshouses.domain.ports.out.CategoryPersistencePort;




public class CategoryUseCase implements CategoryServicePort {

    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void save(CategoryModel categoryModel) {
        CategoryModel category = categoryPersistencePort.getCategoryByName(categoryModel.getName());
        if (category != null) {
            throw new CategoryAlreadyExistsException();
        }
        categoryPersistencePort.save(categoryModel);

    }


    @Override
    public PaginationResponse<CategoryModel> getCategoriesByName(String name, PaginationRequest paginationRequest) {
        //return categoryPersistencePort.getCategoriesByName(name, paginationRequest);
        return null;
    }

}
