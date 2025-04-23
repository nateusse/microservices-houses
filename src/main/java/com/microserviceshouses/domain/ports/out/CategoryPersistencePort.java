package com.microserviceshouses.domain.ports.out;

import com.microserviceshouses.domain.model.CategoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CategoryPersistencePort {
    void save(CategoryModel categoryModel);
    boolean existsByName(String name);
    CategoryModel getCategoryByName(String name);
    Page<CategoryModel> getCategoriesByName(String name, Pageable pageable);
}