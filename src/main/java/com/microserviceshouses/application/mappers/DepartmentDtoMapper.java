package com.microserviceshouses.application.mappers;

import com.microserviceshouses.application.dto.request.SaveDepartmentRequest;
import com.microserviceshouses.domain.model.DepartmentModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentDtoMapper {
    DepartmentModel requestToModel(SaveDepartmentRequest request);
}
