package com.microserviceshouses.infrastructure.mappers;

import com.microserviceshouses.domain.model.CityDepartmentModel;
import com.microserviceshouses.infrastructure.entity.CityDepartmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityDepartmentEntityMapper {

    CityDepartmentEntity modelToEntity(CityDepartmentModel cityDepartmentModel);
    CityDepartmentModel entityToModel(CityDepartmentEntity cityDepartmentEntity);

}
