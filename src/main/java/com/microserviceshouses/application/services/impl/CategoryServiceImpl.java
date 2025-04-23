package com.microserviceshouses.application.services.impl;

import com.microserviceshouses.application.dto.request.SaveCategoryRequest;
import com.microserviceshouses.application.dto.response.CategoryResponse;
import com.microserviceshouses.application.dto.response.PageDto;
import com.microserviceshouses.application.dto.response.SaveCategoryResponse;
import com.microserviceshouses.application.mappers.CategoryDtoMapper;
import com.microserviceshouses.application.services.CategoryService;
import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.ports.in.CategoryServicePort;
import com.microserviceshouses.commons.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;

    @Override
    public SaveCategoryResponse save(SaveCategoryRequest request) {
        categoryServicePort.save(categoryDtoMapper.requestToModel(request));
        return new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public PageDto<CategoryResponse> getCategories(String name, int page, int size, boolean orderAsc) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderAsc ? Sort.Direction.ASC : Sort.Direction.DESC, "name"));
        Page<CategoryModel> categoryPage = categoryServicePort.getCategoriesByName(name, pageable);
        List<CategoryResponse> responseList = new ArrayList<>();
        for (CategoryModel model : categoryPage.getContent()) {
            responseList.add(categoryDtoMapper.modelToResponse(model));
        }
        return new PageDto<>(
                responseList,
                categoryPage.getNumber(),
                categoryPage.getSize(),
                categoryPage.getTotalElements(),
                categoryPage.getTotalPages(),
                categoryPage.hasNext()
        );
    }


}
