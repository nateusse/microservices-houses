package com.microserviceshouses.domain.ports.in;

import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.model.pagination.PaginationRequestModel;
import com.microserviceshouses.domain.model.pagination.PaginationResponseModel;

import java.util.List;


public interface CategoryServicePort {
    void save(CategoryModel categoryModel);
    PaginationResponseModel<CategoryModel> getCategories(PaginationRequestModel paginationRequestModel);
}
