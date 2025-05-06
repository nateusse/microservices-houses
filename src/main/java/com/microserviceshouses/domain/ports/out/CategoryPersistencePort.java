package com.microserviceshouses.domain.ports.out;

import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.model.pagination.PaginationRequestModel;
import com.microserviceshouses.domain.model.pagination.PaginationResponseModel;


public interface CategoryPersistencePort {
    void save(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
    PaginationResponseModel<CategoryModel> getCategories(PaginationRequestModel paginationRequestModel);
}