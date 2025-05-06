package com.microserviceshouses.application.mappers;


import com.microserviceshouses.application.dto.request.SaveCityRequest;
import com.microserviceshouses.domain.model.CityModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityDtoMapper {
    CityModel requestToModel(SaveCityRequest saveCityRequest);
}



