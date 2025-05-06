package com.microserviceshouses.application.services.impl;

import com.microserviceshouses.application.dto.request.SaveCategoryRequest;
import com.microserviceshouses.application.dto.response.CategoryResponse;
import com.microserviceshouses.application.dto.response.PaginationResponse;
import com.microserviceshouses.application.dto.response.SaveCategoryResponse;
import com.microserviceshouses.application.mappers.CategoryDtoMapper;
import com.microserviceshouses.application.mappers.PaginationDtoMapper;
import com.microserviceshouses.application.services.CategoryService;
import com.microserviceshouses.commons.configurations.utils.Constants;
import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.domain.model.pagination.PaginationRequestModel;
import com.microserviceshouses.domain.model.pagination.PaginationResponseModel;
import com.microserviceshouses.domain.ports.in.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;
    private final PaginationDtoMapper paginationDtoMapper;

    @Override
    public SaveCategoryResponse save(SaveCategoryRequest request) {
        CategoryModel category = categoryDtoMapper.requestToModel(request);
        categoryServicePort.save(category);
        LocalDateTime time = LocalDateTime.now();
        return new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, time);
    }

    @Override
    public PaginationResponse<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc) {
        PaginationRequestModel paginationRequestModel = paginationDtoMapper.requestToModel(page, size, orderAsc);
        PaginationResponseModel<CategoryModel> paginationResponseModel = categoryServicePort.getCategories(paginationRequestModel);
        List<CategoryResponse> responses = categoryDtoMapper.modelListToResponseList(paginationResponseModel.getContent());
        return new PaginationResponse<>(responses, paginationResponseModel.getTotalPages(), paginationResponseModel.getTotalElements());
    }

}