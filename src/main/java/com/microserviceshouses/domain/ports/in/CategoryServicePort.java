package com.microserviceshouses.domain.ports.in;

import com.microserviceshouses.domain.model.CategoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CategoryServicePort {
    void save(CategoryModel categoryModel);
    Page<CategoryModel> getCategoriesByName(String name, Pageable pageable);

}
