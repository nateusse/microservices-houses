package com.microserviceshouses.infrastructure.mappers;

import com.microserviceshouses.domain.model.CategoryModel;
import com.microserviceshouses.infrastructure.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    CategoryEntity modelToEntity(CategoryModel categoryModel);
    CategoryModel entityToModel(CategoryEntity categoryEntity);
    List<CategoryModel> entityListToModelList(List<CategoryEntity> categories);
}
