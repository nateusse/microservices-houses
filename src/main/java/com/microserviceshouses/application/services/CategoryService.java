package com.microserviceshouses.application.services;

import com.microserviceshouses.application.dto.request.SaveCategoryRequest;
import com.microserviceshouses.application.dto.response.CategoryResponse;
import com.microserviceshouses.application.dto.response.SaveCategoryResponse;
import java.util.List;


public interface CategoryService {

    SaveCategoryResponse save(SaveCategoryRequest request);
    List<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);

}