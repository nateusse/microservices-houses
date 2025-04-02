package com.microserviceshouses.application.mappers;

import com.microserviceshouses.application.dto.request.SaveDepartmentRequest;
import com.microserviceshouses.application.dto.response.DepartmentResponse;
import com.microserviceshouses.domain.model.DepartmentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentDtoMapper {

    default DepartmentModel requestToModel(SaveDepartmentRequest request) {
        return new DepartmentModel(null, request.name(), request.description());
    }

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    DepartmentResponse modelToResponse(DepartmentModel departmentModel);
}



