package com.microserviceshouses.category.domain.usecases;

import com.microserviceshouses.category.domain.model.CategoryModel;
import com.microserviceshouses.category.domain.ports.in.CategoryServicePort;
import com.microserviceshouses.category.domain.ports.out.CategoryPersistencePort;

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
            throw new RuntimeException("Category already exists");
        }
        categoryPersistencePort.save(categoryModel);

    }

    @Override
    public List<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        return categoryPersistencePort.getCategories(page, size, orderAsc);
    }


}
