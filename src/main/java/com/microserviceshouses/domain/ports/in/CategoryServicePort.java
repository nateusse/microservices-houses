package com.microserviceshouses.domain.ports.in;

import com.microserviceshouses.domain.model.CategoryModel;


public interface CategoryServicePort {
    void save(CategoryModel categoryModel);

}
