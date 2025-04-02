package com.microserviceshouses.application.mappers;


import com.microserviceshouses.application.dto.request.SaveCityRequest;
import com.microserviceshouses.application.dto.response.CityResponse;
import com.microserviceshouses.domain.model.CityModel;
import com.microserviceshouses.domain.model.DepartmentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityDtoMapper {

    default CityModel requestToModel(SaveCityRequest request) {
        DepartmentModel department = new DepartmentModel(request.departmentId());
        return new CityModel(null, request.name(), request.description(), department);
    }


    @Mapping(source = "department.name", target = "departmentName")
    CityResponse modelToResponse(CityModel cityModel);

    List<CityResponse> modelListToResponseList(List<CityModel> models);
}




