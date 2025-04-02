package com.microserviceshouses.infrastructure.mappers;

import com.microserviceshouses.domain.model.CityModel;
import com.microserviceshouses.infrastructure.entity.CityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = DepartmentEntityMapper.class)
public interface CityEntityMapper {
    CityEntity modelToEntity(CityModel model);
    CityModel entityToModel(CityEntity entity);
}