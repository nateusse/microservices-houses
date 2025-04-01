package com.microserviceshouses.category.application.services;

import com.microserviceshouses.category.application.dto.request.SaveCategoryRequest;
import com.microserviceshouses.category.application.dto.response.CategoryResponse;
import com.microserviceshouses.category.application.dto.response.SaveCategoryResponse;
import java.util.List;


public interface CategoryService {

    SaveCategoryResponse save(SaveCategoryRequest request);
    List<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);

}