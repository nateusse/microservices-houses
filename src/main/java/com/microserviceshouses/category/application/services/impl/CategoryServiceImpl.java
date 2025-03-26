package com.microserviceshouses.category.application.services.impl;

import com.microserviceshouses.category.application.dto.request.SaveCategoryRequest;
import com.microserviceshouses.category.application.dto.response.CategoryResponse;
import com.microserviceshouses.category.application.dto.response.SaveCategoryResponse;
import com.microserviceshouses.category.application.mappers.CategoryDtoMapper;
import com.microserviceshouses.category.application.services.CategoryService;
import com.microserviceshouses.category.domain.ports.in.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;

    @Override
    public SaveCategoryResponse save(SaveCategoryRequest request) {
        categoryServicePort.save(categoryDtoMapper.requestToModel(request));
        //TODO add exception constants
        return new SaveCategoryResponse("Category saved successfully", LocalDateTime.now());
    }




}
