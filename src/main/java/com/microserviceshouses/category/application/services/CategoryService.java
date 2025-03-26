package com.microserviceshouses.category.application.services;

import com.microserviceshouses.category.application.dto.request.SaveCategoryRequest;
import com.microserviceshouses.category.application.dto.response.SaveCategoryResponse;


public interface CategoryService {
    SaveCategoryResponse save(SaveCategoryRequest request);


}