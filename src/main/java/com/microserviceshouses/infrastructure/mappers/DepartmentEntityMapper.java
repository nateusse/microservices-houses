package com.microserviceshouses.infrastructure.mappers;

import com.microserviceshouses.domain.model.DepartmentModel;
import com.microserviceshouses.infrastructure.entity.DepartmentEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface DepartmentEntityMapper {

    DepartmentEntity modelToEntity(DepartmentModel departmentModel);

    default DepartmentModel entityToModel(DepartmentEntity entity) {
        return new DepartmentModel(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }
}


