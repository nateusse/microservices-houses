package com.microserviceshouses.domain.ports.in;

import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.model.PaginationRequest;
import com.microserviceshouses.domain.model.PaginationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CategoryServicePort {
    void save(CategoryModel categoryModel);
    PaginationResponse<CategoryModel> getCategoriesByName(String name, PaginationRequest paginationRequest);

}
