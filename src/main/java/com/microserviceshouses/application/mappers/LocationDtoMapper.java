package com.microserviceshouses.application.mappers;

import com.microserviceshouses.application.dto.request.SaveLocationRequest;
import com.microserviceshouses.application.dto.response.LocationResponse;
import com.microserviceshouses.domain.model.CityModel;
import com.microserviceshouses.domain.model.DepartmentModel;
import com.microserviceshouses.domain.model.LocationModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationDtoMapper {

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "city", expression = "java(toCityModel(request))")
    LocationModel requestToModel(SaveLocationRequest request);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "sectorOrNeighborhood", target = "sectorOrNeighborhood")
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "city.department.name", target = "departmentName")
    LocationResponse modelToResponse(LocationModel model);

    // Métodos auxiliares
    default CityModel toCityModel(SaveLocationRequest request) {
        return new CityModel(
                UUID.randomUUID(), // o null si es generado por la BD
                request.cityName(),
                request.cityDescription(),
                toDepartmentModel(request)
        );
    }

    default DepartmentModel toDepartmentModel(SaveLocationRequest request) {
        return new DepartmentModel(
                UUID.randomUUID(), // o null
                request.departmentName(),
                request.departmentDescription()
        );
    }
}
