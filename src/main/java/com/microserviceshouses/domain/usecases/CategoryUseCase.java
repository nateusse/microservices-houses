package com.microserviceshouses.domain.usecases;

import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.ports.in.CategoryServicePort;
import com.microserviceshouses.domain.ports.out.CategoryPersistencePort;
import com.microserviceshouses.domain.exceptions.CategoryAlreadyExistsException;

import java.util.List;


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
    public List<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        return categoryPersistencePort.getCategories(page, size, orderAsc);
    }



}
