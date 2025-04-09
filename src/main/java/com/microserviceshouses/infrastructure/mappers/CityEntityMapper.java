package com.microserviceshouses.infrastructure.mappers;

import com.microserviceshouses.domain.model.CityModel;
import com.microserviceshouses.domain.model.DepartmentModel;
import com.microserviceshouses.infrastructure.entity.CityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = DepartmentEntityMapper.class)
public interface CityEntityMapper {
    CityEntity modelToEntity(CityModel model);
    default CityModel entityToModel(CityEntity entity) {
        return new CityModel(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                new DepartmentModel(entity.getDepartment().getId())
        );
    }
}