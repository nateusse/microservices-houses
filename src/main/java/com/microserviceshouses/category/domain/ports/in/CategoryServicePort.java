package com.microserviceshouses.category.domain.ports.in;

import com.microserviceshouses.category.domain.model.CategoryModel;



public interface CategoryServicePort {
    void save(CategoryModel categoryModel);

}
