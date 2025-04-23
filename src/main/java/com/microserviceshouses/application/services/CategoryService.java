package com.microserviceshouses.application.services;

import com.microserviceshouses.application.dto.request.SaveCategoryRequest;
import com.microserviceshouses.application.dto.response.CategoryResponse;
import com.microserviceshouses.application.dto.response.PageDto;
import com.microserviceshouses.application.dto.response.SaveCategoryResponse;


public interface CategoryService {

    SaveCategoryResponse save(SaveCategoryRequest request);
    PageDto<CategoryResponse> getCategories(String name, int page, int size, boolean orderAsc);


}