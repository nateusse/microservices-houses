package com.microserviceshouses.application.mappers;

import com.microserviceshouses.application.dto.request.SaveCategoryRequest;
import com.microserviceshouses.application.dto.response.CategoryResponse;
import com.microserviceshouses.domain.model.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryDtoMapper {
    CategoryModel requestToModel(SaveCategoryRequest saveCategoryRequest);
    CategoryResponse modelToResponse(CategoryModel categoryModel);
    List<CategoryResponse> modelListToResponseList(List<CategoryModel> categories);
}
