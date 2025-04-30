package com.microserviceshouses.application.services;

import com.microserviceshouses.application.dto.request.SaveCategoryRequest;
import com.microserviceshouses.application.dto.response.SaveCategoryResponse;


public interface CategoryService {
    SaveCategoryResponse save(SaveCategoryRequest request);


}