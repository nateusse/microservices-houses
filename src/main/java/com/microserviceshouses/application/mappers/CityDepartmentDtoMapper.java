package com.microserviceshouses.application.mappers;

import com.microserviceshouses.application.dto.request.SaveCityDepartmentRequest;
import com.microserviceshouses.domain.model.CityDepartmentModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityDepartmentDtoMapper {
    CityDepartmentModel requestToModel(SaveCityDepartmentRequest saveCityDepartmentRequest);
}
