package com.microserviceshouses.application.mappers;

import com.microserviceshouses.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.application.dto.response.LocationResponse;
import com.microserviceshouses.domain.model.CityModel;
import com.microserviceshouses.domain.model.DepartmentModel;
import com.microserviceshouses.domain.model.LocationModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationDtoMapper {

    LocationModel requestToModel(SaveLocationRequest locationRequest);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "sectorOrNeighborhood", target = "sectorOrNeighborhood")
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "city.department.name", target = "departmentName")
    LocationResponse modelToResponse(LocationModel locationModel);

    List<LocationResponse> modelListToResponseList(List<LocationModel> locations);
}
