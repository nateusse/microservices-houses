package com.microserviceshouses.application.services.impl;

import com.microserviceshouses.application.dto.request.SaveCategoryRequest;
import com.microserviceshouses.application.dto.response.SaveCategoryResponse;
import com.microserviceshouses.application.mappers.CategoryDtoMapper;
import com.microserviceshouses.application.services.CategoryService;
import com.microserviceshouses.domain.ports.in.CategoryServicePort;
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
